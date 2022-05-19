package com.zhonglv.benchmarking.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CommonResult;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.entity.IndicatorsStatistics;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.IndicatorsAccumulate;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ComprehensiveIndex;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.IndicatorsExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.IndicatorsPo;
import com.zhonglv.benchmarking.domain.mapper.IndicatorsMapper;
import com.zhonglv.benchmarking.domain.mapper.SeriesInfoMapper;
import com.zhonglv.benchmarking.handler.excel.ExcelDataHandler;
import com.zhonglv.benchmarking.handler.excel.ExcelHandleFactory;
import com.zhonglv.benchmarking.service.IndicatorsService;
import com.zhonglv.benchmarking.service.IndicatorsStatisticsService;
import com.zhonglv.benchmarking.utils.ExcelFillCellMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFreezeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
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

    @Autowired
    private IndicatorsStatisticsService indicatorsStatisticsService;

    /**
     * 获取系列数据
     *
     * @param seriesNames     seriesNames
     * @param indicatorsNames indicatorsNames
     * @param countYear       countYear
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    @Override
    public Result<IndicatorsPo> getIndicators(String seriesNames, String indicatorsNames, String countYear,
                                              String startTime, String endTime) {
        List<String> seriesNamesList = new ArrayList<>();
        if (StringUtils.isNotEmpty(seriesNames)) {
            String[] split = seriesNames.split(",");
            seriesNamesList = Arrays.asList(split);
        }

        List<String> indicatorsNamesList = new ArrayList<>();
        if (StringUtils.isNotEmpty(indicatorsNames)) {
            String[] split = indicatorsNames.split(",");
            indicatorsNamesList = Arrays.asList(split);
        }

        List<Indicators> indicatorsList = seriesInfoMapper.selectIndicators(seriesNamesList, indicatorsNamesList,
                null, countYear, startTime, endTime);

        Map<String, List<IndicatorsDto>> groupIndicators = getGroupIndicators(Indicators::getSeriesName, indicatorsList);

        Set<String> groupList = indicatorsList.stream()
                .map(Indicators::getGroupName)
                .collect(Collectors.toSet());

        List<String> standard = groupList.stream()
                .filter(s -> CacheMap.MONTH_MAP.get(s) == null)
                .map(CacheMap.MODEL_MAP::get)
                .collect(Collectors.toList());

        Map<String, List<IndicatorsDto>> standardMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(standard)) {
            List<Indicators> standardIndicators = seriesInfoMapper.selectIndicators(standard, indicatorsNamesList,
                    null, countYear, startTime, endTime);
            standardMap = getGroupIndicators(Indicators::getGroupName, standardIndicators);
        }

        Map<String, String> map = new TreeMap<>();
        assemblyMap(standardMap, map);

        Map<String, List<ComprehensiveIndex>> indexMap = new TreeMap<>();
        Map<String, Map<String, List<IndicatorsDto>>> indicesMap = new TreeMap<>();

        for (Map.Entry<String, List<IndicatorsDto>> entry : groupIndicators.entrySet()) {
            List<IndicatorsDto> value = entry.getValue();

            Map<String, List<IndicatorsDto>> listMap = value.stream()
                    .collect(Collectors.groupingBy(
                            indicatorsDto -> indicatorsDto.getDateMonth() + "_" + indicatorsDto.getAbscissa(),
                            TreeMap::new,
                            Collectors.toList()));
            indicesMap.put(entry.getKey(), listMap);

            Map<String, List<IndicatorsDto>> collect = value.stream()
                    .collect(Collectors.groupingBy(IndicatorsDto::getDateMonth,
                            TreeMap::new,
                            Collectors.toList()));

            Map<String, ComprehensiveIndex> indexHashMap = new TreeMap<>();
            for (Map.Entry<String, List<IndicatorsDto>> listEntry : collect.entrySet()) {
                List<IndicatorsDto> indicatorsDtos = listEntry.getValue();
                if (CollectionUtil.isNotEmpty(indicatorsDtos)) {
                    IndicatorsDto indicatorsDto = indicatorsDtos.get(0);
                    ComprehensiveIndex comprehensiveIndex = new ComprehensiveIndex();
                    comprehensiveIndex.setAbscissa(indicatorsDto.getAbscissa());
                    comprehensiveIndex.setDateMouth(indicatorsDto.getDateMonth());
                    comprehensiveIndex.setComprehensiveIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex());
                    String standardIndex = map.get(indicatorsDto.getGroupName() + "_" + indicatorsDto.getDateMonth());
                    comprehensiveIndex.setStandardComprehensiveIndex(standardIndex);
                    indexHashMap.put(indicatorsDto.getDateMonth() + "_" + indicatorsDto.getAbscissa(), comprehensiveIndex);
                }
            }
            List<ComprehensiveIndex> comprehensiveIndexList = indexHashMap.values().stream()
                    .sorted(Comparator.comparing(ComprehensiveIndex::getDateMouth))
                    .collect(Collectors.toList());
            indexMap.put(entry.getKey(), comprehensiveIndexList);
        }

        IndicatorsPo indicatorsPo = new IndicatorsPo()
                .setIndicatorsMap(groupIndicators)
                .setIndexMap(indexMap)
                .setIndicesMap(indicesMap);

        return new Result<IndicatorsPo>().toSuccess(indicatorsPo);
    }

    private void assemblyMap(Map<String, List<IndicatorsDto>> standardMap, Map<String, String> map) {
        for (Map.Entry<String, List<IndicatorsDto>> entry : standardMap.entrySet()) {
            List<IndicatorsDto> value = entry.getValue();
            Map<String, List<IndicatorsDto>> collect = value.stream()
                    .collect(Collectors.groupingBy(IndicatorsDto::getDateMonth,
                            TreeMap::new,
                            Collectors.toList()));
            for (Map.Entry<String, List<IndicatorsDto>> listEntry : collect.entrySet()) {
                List<IndicatorsDto> indicatorsDtos = listEntry.getValue();
                if (CollectionUtil.isNotEmpty(indicatorsDtos)) {
                    IndicatorsDto indicatorsDto = indicatorsDtos.get(0);
                    map.put(entry.getKey() + "_" + listEntry.getKey(), indicatorsDto.getSeriesComprehensiveCapabilityIndex());
                }
            }
        }
    }

    private Map<String, List<IndicatorsDto>> getGroupIndicators(Function<Indicators, String> classifier, List<Indicators> standardIndicators) {
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

    /**
     * 获取系列数据
     *
     * @param indicatorsNames indicatorsNames
     * @param seriesType      seriesType
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    @Override
    public Result<IndicatorsPo> getIndicatorsByType(String indicatorsNames, String seriesType,
                                                    String countYear, String startTime, String endTime) {
        List<String> indicatorsNamesList = new ArrayList<>();
        if (StringUtils.isNotEmpty(indicatorsNames)) {
            String[] split = indicatorsNames.split(",");
            indicatorsNamesList = Arrays.asList(split);
        }

        List<Indicators> indicatorsList = seriesInfoMapper.selectIndicators(null, indicatorsNamesList,
                seriesType, countYear, startTime, endTime);
        Map<String, Map<String, List<IndicatorsDto>>> stringMapMap = indicatorsList.stream()
                .collect(Collectors.groupingBy(Indicators::getGroupName,
                        Collectors.groupingBy(Indicators::getSeriesName, Collectors.mapping(indicators -> {
                            IndicatorsDto indicatorsDto = new IndicatorsDto();
                            BeanUtils.copyProperties(indicators, indicatorsDto);
                            return indicatorsDto;
                        }, Collectors.toList()))));

        List<ExcelPo> excelPoList = new ArrayList<>();
        if (StringUtils.isNotBlank(seriesType)) {
            Optional<ExcelDataHandler> assemblyHandle = ExcelHandleFactory.getAssemblyHandle(seriesType);
            if (assemblyHandle.isPresent()) {
                assemblyHandle.ifPresent(excelDataHandler ->
                        assemblyHandle.get().assemblyExcel(stringMapMap, excelPoList));
            } else {
                log.info("This series type does not exist! type:{}", seriesType);
            }
        }

        return new Result<IndicatorsPo>().toSuccess(
                new IndicatorsPo()
                        .setIndicesMap(stringMapMap)
                        .setExcelPoList(excelPoList));
    }

    /**
     * download
     *
     * @param seriesName seriesName
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    @Override
    public void download(String seriesName, String startTime, String endTime, HttpServletResponse response) {
        Result<IndicatorsPo> indicators = getIndicators(seriesName, null, null, startTime, endTime);
        if (!CommonResult.SUCCESS.getCode().equals(indicators.getCode())) {
            Result.responseError(response, JSON.toJSONString(indicators));
            return;
        }
        Map<String, List<IndicatorsDto>> indicatorsMap = indicators.getData().getIndicatorsMap();
        List<IndicatorsDto> indicatorsDtoList = indicatorsMap.get(seriesName);
        if (CollectionUtil.isEmpty(indicatorsDtoList)) {
            Result<Object> result = new Result<>().toFailed("Department query data is null");
            Result.responseError(response, JSON.toJSONString(result));
            return;
        }

        AtomicReference<String> name = new AtomicReference<>();
        List<IndicatorsExcelPo> indicatorsExcelDtos = new ArrayList<>(indicatorsDtoList.size());
        indicatorsDtoList.forEach(indicatorsDto -> {
            name.set(indicatorsDto.getBenchmarkingEnterprise());
            IndicatorsExcelPo indicatorsExcelDto = new IndicatorsExcelPo();
            BeanUtils.copyProperties(indicatorsDto, indicatorsExcelDto);
            indicatorsExcelDto.setNumber(indicatorsDto.getINumber());
            indicatorsExcelDtos.add(indicatorsExcelDto);
        });

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode(seriesName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + System.currentTimeMillis() + ".xlsx");
            // 这里需要设置不关闭流
            ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream(), IndicatorsExcelPo.class);
            int[] integers = {12};
            write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 1));
            write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 2));
            write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 11));
            write.registerWriteHandler(new ExcelFillCellMergeStrategy(3, integers));
            write.registerWriteHandler(new ExcelFreezeStrategy(0, 3, 0, 3));
            write.head(head(seriesName, name)).autoCloseStream(Boolean.FALSE).sheet(seriesName).doWrite(indicatorsExcelDtos);
        } catch (Exception e) {
            // 重置response
            response.reset();
            Result<IndicatorsPo> result = new Result<IndicatorsPo>().toFailed("Download file failed " + e.getMessage());
            Result.responseError(response, JSON.toJSONString(result));
        }
    }

    private static List<List<String>> head(String seriesName, AtomicReference<String> name) {
        List<List<String>> headTitles = Lists.newArrayList();
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.INDEX_SERIAL_NUMBER));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.PROCESS_CLASSIFICATION));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.INDICATOR_CATEGORY));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.INDEX));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.UNIT));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.INDEX_LEVEL));
        headTitles.add(Arrays.asList(seriesName, seriesName, name.get() + "(" + ConstantType.BENCHMARK_VALUE + ")"));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.COMPLETION_VALUE));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.STANDARD_DEVIATION));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.WEIGHTS));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.SINGLE_INDEX));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.COMPREHENSIVE_INDEX));
        headTitles.add(Arrays.asList(seriesName, seriesName, ConstantType.SERIES_INDEX));
        return headTitles;
    }

    /**
     * download
     *
     * @param seriesType seriesType
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    @Override
    public void downloadCountByType(String seriesType, String startTime, String endTime, HttpServletResponse response) {
        Result<IndicatorsPo> indicators = getIndicatorsByType(null, seriesType, null, startTime, endTime);
        if (!CommonResult.SUCCESS.getCode().equals(indicators.getCode())) {
            log.info(indicators.getMsg());
            Result.responseError(response, JSON.toJSONString(indicators));
            return;
        }
        List<ExcelPo> excelPoList = indicators.getData().getExcelPoList();
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String grade = CacheMap.GRADE_MAP.get(seriesType);
            String fileName = URLEncoder.encode(grade, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + System.currentTimeMillis() + ".xlsx");
            // 这里需要设置不关闭流
            ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream(), CacheMap.EXCEL_WRITE_CLASS_MAP.get(seriesType));
            Optional<ExcelDataHandler> handle = ExcelHandleFactory.getAssemblyHandle(seriesType);
            if (!handle.isPresent()) {
                log.info("This series type does not exist! type:{}", seriesType);
                throw new RuntimeException("This series type does not exist! ");
            }
            handle.get().writeExcelHandle(write);
            List<List<String>> head = CacheMap.HEAD_MAP.get(seriesType);
            write.head(head).autoCloseStream(Boolean.FALSE).sheet(grade).doWrite(excelPoList);
        } catch (Exception e) {
            // 重置response
            response.reset();
            Result<IndicatorsPo> result = new Result<IndicatorsPo>().toFailed("Download file failed " + e.getMessage());
            Result.responseError(response, JSON.toJSONString(result));
        }
    }

    /**
     * 指标统计平均累计值
     *
     * @param seriesName seriesName
     * @param year       year
     * @return Result
     */
    @Override
    public Result<Object> cumulativeValue(String seriesName, String year) {
        LambdaQueryWrapper<Indicators> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Indicators::getSeriesName, seriesName);
        queryWrapper.eq(Indicators::getYear, year);
        List<Indicators> indicatorsList = indicatorsMapper.selectList(queryWrapper);
        Map<String, List<Indicators>> listMap = indicatorsList.stream().collect(Collectors.groupingBy(Indicators::getDateMonth));

        Integer monthCount = listMap.keySet().size();

        if (monthCount == 0) {
            log.info("The query data is empty! seriesName: {}, year: {}", seriesName, year);
            return new Result<>().toFailed("The query data is empty!");
        }

        Map<String, Double> totalMap = indicatorsList.stream().collect(Collectors.groupingBy(
                indicators -> indicators.getWorkingProcedureClassification() + "_" + indicators.getIndicatorsName(),
                Collectors.summingDouble(indicator -> Double.parseDouble(indicator.getCompletionValue()))));

        Map<String, IndicatorsStatistics> countMap = totalMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                stringDoubleEntry -> {
                    double count = stringDoubleEntry.getValue() / monthCount;
                    IndicatorsStatistics indicatorsStatistics = new IndicatorsStatistics();
                    String entryKey = stringDoubleEntry.getKey();
                    String[] split = entryKey.split("_");
                    indicatorsStatistics.setWorkingProcedureClassification(split[0]);
                    indicatorsStatistics.setIndicatorsName(split[1]);
                    indicatorsStatistics.setSeriesName(seriesName);
                    indicatorsStatistics.setAccumulation(new BigDecimal(count));
                    indicatorsStatistics.setYear(year);
                    indicatorsStatistics.setCreateTime(new Date());
                    return indicatorsStatistics;
                }, (oldValue, newValue) -> newValue));

        LambdaQueryWrapper<IndicatorsStatistics> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IndicatorsStatistics::getSeriesName, seriesName);
        wrapper.eq(IndicatorsStatistics::getYear, year);
        indicatorsStatisticsService.delete(wrapper);

        indicatorsStatisticsService.saveBatch(countMap.values());
        return new Result<>().toSuccess();
    }

    /**
     * 按类型获取每月累计值列表
     *
     * @param seriesType seriesType
     * @param countYear  countYear
     * @return result
     */
    @Override
    public Result<IndicatorsAccumulate> getCumulativeValue(String seriesType, String countYear) {
        Set<String> excludeHeads = new HashSet<>();
        Set<String> includeHeads = new HashSet<>();
        List<MonthExcelPo> excelPoList = getMonthExcelPoList(seriesType, countYear, excludeHeads, includeHeads);

        IndicatorsAccumulate indicatorsAccumulate = new IndicatorsAccumulate();
        indicatorsAccumulate.setPropertyList(includeHeads)
                .setMonthExcelPoList(excelPoList);

        return new Result<IndicatorsAccumulate>()
                .setCode(CommonResult.SUCCESS.getCode())
                .setMsg(CommonResult.SUCCESS.getMsg())
                .setData(indicatorsAccumulate);
    }

    /**
     * 按类型导出每月累计值
     *
     * @param seriesType seriesType
     * @param countYear  countYear
     * @param response   response
     */
    @Override
    public void downloadCountByType(String seriesType, String countYear, HttpServletResponse response) {
        Set<String> excludeHeads = new HashSet<>();
        List<MonthExcelPo> excelPoList = getMonthExcelPoList(seriesType, countYear, excludeHeads, new HashSet<>());
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String grade = CacheMap.GRADE_MAP.get(seriesType) + "年度累计平均值";
            String fileName = URLEncoder.encode(grade, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + System.currentTimeMillis() + ".xlsx");
            // 这里需要设置不关闭流
            ExcelWriterBuilder write = EasyExcel.write(response.getOutputStream(), CacheMap.MONTH_EXCEL_WRITE_CLASS_MAP.get(seriesType));

            if (excludeHeads.size() > 0) {
                write.excludeColumnFiledNames(excludeHeads);
            }

            write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 1));
            write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 2));
            write.registerWriteHandler(new ExcelFreezeStrategy(0, 3, 0, 3));

            write.head(CacheMap.MONTH_EXCEL_WRITE_CLASS_MAP.get(seriesType)).autoCloseStream(Boolean.FALSE).sheet(grade).doWrite(excelPoList);
        } catch (Exception e) {
            // 重置response
            response.reset();
            Result<IndicatorsPo> result = new Result<IndicatorsPo>().toFailed("Download file failed " + e.getMessage());
            Result.responseError(response, JSON.toJSONString(result));
        }
    }

    private List<MonthExcelPo> getMonthExcelPoList(String seriesType, String countYear, Set<String> excludeHeads,
                                                   Set<String> includeHeads) {
        List<Indicators> indicatorsList = seriesInfoMapper.selectIndicators(null, null,
                seriesType, countYear, null, null);

        Map<String, Map<String, List<IndicatorsDto>>> stringMapMap = indicatorsList.stream()
                .sorted(Comparator.comparing(Indicators::getIId))
                .collect(Collectors.groupingBy(Indicators::getGroupName,
                        Collectors.groupingBy(Indicators::getSeriesName, Collectors.mapping(indicators -> {
                            IndicatorsDto indicatorsDto = new IndicatorsDto();
                            BeanUtils.copyProperties(indicators, indicatorsDto);
                            return indicatorsDto;
                        }, Collectors.toList()))));

        List<MonthExcelPo> excelPoList = new ArrayList<>();
        Optional<ExcelDataHandler> assemblyHandle = ExcelHandleFactory.getAssemblyHandle(seriesType);
        if (assemblyHandle.isPresent()) {
            Map<String, List<Indicators>> listMap = indicatorsList.stream().
                    collect(Collectors.groupingBy(Indicators::getMonth));
            assemblyHandle.get().excludeHead(excludeHeads, listMap.keySet());
            assemblyHandle.get().includeHead(includeHeads, listMap.keySet());
            assemblyHandle.get().assemblyMonthExcel(stringMapMap, excelPoList);
        } else {
            log.info("This series type does not exist! type:{}", seriesType);
        }
        return excelPoList;
    }
}

