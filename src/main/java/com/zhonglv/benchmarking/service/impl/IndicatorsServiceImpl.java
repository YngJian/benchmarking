package com.zhonglv.benchmarking.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CommonResponse;
import com.zhonglv.benchmarking.common.ConstantType;
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
     * @return CommonResponse
     */
    @Override
    public CommonResponse getIndicators(String token, List<String> seriesNames) {
        String redis = stringRedisTemplate.opsForValue().get(ConstantType.TOKEN_KEY + token);
        if (StringUtils.isBlank(redis)) {
            log.info("The token has expired.");
            return new CommonResponse().invalidParameter("The token has expired.");
        }
        UserInfoDto userInfoDto = JSONObject.parseObject(redis, UserInfoDto.class);
        List<SeriesInfo> seriesInfoList = userInfoDto.getSeriesInfoList();
        if (CollectionUtil.isEmpty(seriesInfoList)) {
            log.info("This user does not have any data rights!");
            return new CommonResponse().invalidParameter("This user does not have any data rights!");
        }

        Set<String> series = seriesInfoList.stream().map(SeriesInfo::getInfo).collect(Collectors.toSet());
        List<String> seriesNamesList = new ArrayList<>(series);

        if (CollectionUtil.isNotEmpty(seriesNames)) {
            boolean anyMatch = seriesNames.stream().anyMatch(s -> !series.contains(s));
            if (anyMatch) {
                log.info("Please pass in the correct parameter, which contains the unexisted viewing permission!");
                return new CommonResponse().invalidParameter("Please pass in the correct parameter, which contains the unexisted viewing permission!");
            }
            seriesNamesList = seriesNames;
        }
        List<Indicators> indicatorsList = seriesInfoMapper.selectIndicators(seriesNamesList);

        Map<String, List<Indicators>> groupIndicators = getGroupIndicators(Indicators::getSeriesName, indicatorsList);

        Set<String> groupList = indicatorsList.stream().map(Indicators::getGroupName).collect(Collectors.toSet());
        List<String> standard = groupList.stream().map(CacheMap.MONTH_MAP::get).collect(Collectors.toList());
        Map<String, List<Indicators>> standardMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(standard)) {
            List<Indicators> standardIndicators = seriesInfoMapper.selectIndicators(standard);
            standardMap = getGroupIndicators(Indicators::getGroupName, standardIndicators);
        }
        IndicatorsPo indicatorsPo = new IndicatorsPo()
                .setIndicatorsMap(groupIndicators)
                .setStandardMap(standardMap);

        return new CommonResponse().success().data(indicatorsPo);
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

