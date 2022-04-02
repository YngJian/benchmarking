package com.zhonglv.benchmarking.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CommonResult;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserInfoDto;
import com.zhonglv.benchmarking.domain.entity.po.IndicatorsPo;
import com.zhonglv.benchmarking.domain.mapper.SeriesInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.mapper.IndicatorsMapper;
import com.zhonglv.benchmarking.service.IndicatorsService;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class IndicatorsServiceImpl extends ServiceImpl<IndicatorsMapper, Indicators> implements IndicatorsService {
    @Autowired
    private IndicatorsMapper indicatorsMapper;

    @Autowired
    private SeriesInfoMapper seriesInfoMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取系列数据
     *
     * @param token       token
     * @param seriesNames seriesNames
     * @param startTime startTime
     * @param endTime endTime
     * @return CommonResponse
     */
    @Override
    public Result<IndicatorsPo> getIndicators(String token, String seriesNames, String startTime, String endTime) {
        String redis = stringRedisTemplate.opsForValue().get(ConstantType.TOKEN_KEY + token);
        if (StringUtils.isBlank(redis)) {
            log.info("The token has expired.");
            return new Result<>(CommonResult.INVALID_PARAM.getCode(),"The token has expired.",null);
        }
        UserInfoDto userInfoDto = JSONObject.parseObject(redis, UserInfoDto.class);
        List<SeriesInfo> seriesInfoList = userInfoDto.getSeriesInfoList();
        if (CollectionUtil.isEmpty(seriesInfoList)) {
            log.info("This user does not have any data rights!");
            return new Result<>(CommonResult.INVALID_PARAM.getCode(),"This user does not have any data rights!",null);
        }

        Set<String> series = seriesInfoList.stream().map(SeriesInfo::getInfo).collect(Collectors.toSet());
        List<String> seriesNamesList = new ArrayList<>(series);

        if (StringUtils.isNotEmpty(seriesNames)) {
            String[] split = seriesNames.split(",");
            boolean anyMatch = Arrays.stream(split).anyMatch(s -> !series.contains(s));
            if (anyMatch) {
                log.info("Please pass in the correct parameter, which contains the unexisted viewing permission!");
                return new Result<>(CommonResult.INVALID_PARAM.getCode(),"Please pass in the correct parameter, which contains the unexisted viewing permission!",null);
            }
            seriesNamesList = Arrays.asList(split);
        }
        List<Indicators> indicatorsList = seriesInfoMapper.selectIndicators(seriesNamesList, startTime, endTime);

        Map<String, List<Indicators>> groupIndicators = getGroupIndicators(Indicators::getSeriesName, indicatorsList);

        Set<String> groupList = indicatorsList.stream().map(Indicators::getGroupName).collect(Collectors.toSet());
        List<String> standard = groupList.stream().map(CacheMap.MONTH_MAP::get).collect(Collectors.toList());
        Map<String, List<Indicators>> standardMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(standard)) {
            List<Indicators> standardIndicators = seriesInfoMapper.selectIndicators(standard, startTime, endTime);
            standardMap = getGroupIndicators(Indicators::getGroupName, standardIndicators);
        }
        IndicatorsPo indicatorsPo = new IndicatorsPo()
                .setIndicatorsMap(groupIndicators)
                .setStandardMap(standardMap);

        return new Result<IndicatorsPo>().toSuccess(indicatorsPo);
    }

    private Map<String, List<Indicators>> getGroupIndicators(Function<Indicators, String> classifier, List<Indicators> standardIndicators) {
        return standardIndicators.stream().collect(
                Collectors.groupingBy(classifier, Collectors.mapping(indicators -> {
                    IndicatorsDto indicatorsDto = new IndicatorsDto();
                    BeanUtils.copyProperties(indicators, indicatorsDto);
                    indicatorsDto.setAbscissa(CacheMap.MONTH_MAP.get(indicators.getMonth()));
                    String benchmarkValue = indicators.getBenchmarkValue();
                    String completionValue = indicators.getCompletionValue();
                    if (StringUtils.isNotBlank(benchmarkValue) && StringUtils.isNotBlank(completionValue)) {
                        if (NumberUtil.isNumber(benchmarkValue) && NumberUtil.isNumber(completionValue)) {
                            Double sub = sub(benchmarkValue, completionValue);
                            indicatorsDto.setStandardDeviation(String.valueOf(sub));
                        }
                    }
                    return indicatorsDto;
                }, Collectors.toList())));
    }

    /**
     * 两个Double数相减
     *
     * @param v1 v
     * @param v2 v2
     * @return Double
     */
    public static Double sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }
}

