package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CompanyEnum;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.LowMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.LowExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
@Slf4j
public class LowExcelDefaultDataHandler extends LowExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, LowExcelPo> lowExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    LowExcelPo lowExcelPo = lowExcelPoMap.get(iNumber);
                    if (lowExcelPo == null) {
                        lowExcelPo = new LowExcelPo();
                        assemblyData(stringListEntry.getKey(), lowExcelPo, indicatorsDto);
                        lowExcelPoMap.put(iNumber, lowExcelPo);
                    } else {
                        assemblyData(stringListEntry.getKey(), lowExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(lowExcelPoMap.values());
    }

    /**
     * 组装数据处理
     *
     * @param companyName   companyName
     * @param lowExcelPo    lowExcelPo
     * @param indicatorsDto indicatorsDto
     */
    public static void assemblyData(String companyName, LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(lowExcelPo, indicatorsDto);
    }

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
        int[] integers = {11, 15, 19, 23, 27, 31};
        SuperExcelDefaultDataHandler.registerHandler(write, integers);

        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 18));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 22));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 26));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 30));
    }

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyMonthExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<MonthExcelPo> excelPoList) {
        Map<String, LowMonthExcelPo> lowMonthExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    LowMonthExcelPo lowMonthExcelPo = lowMonthExcelPoMap.get(iNumber);
                    if (lowMonthExcelPo == null) {
                        lowMonthExcelPo = new LowMonthExcelPo();
                        dataProcessing(stringListEntry.getKey(), lowMonthExcelPo, indicatorsDto);
                        lowMonthExcelPoMap.put(iNumber, lowMonthExcelPo);
                    } else {
                        dataProcessing(stringListEntry.getKey(), lowMonthExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(lowMonthExcelPoMap.values());
    }

    /**
     * 数据处理
     *
     * @param lowMonthExcelPo lowMonthExcelPo
     * @param indicatorsDto   indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public MonthExcelPo dataProcessing(String companyName, LowMonthExcelPo lowMonthExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(lowMonthExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, lowMonthExcelPo);
            lowMonthExcelPo.setNumber(indicatorsDto.getINumber());
        }
        try {
            Method method = lowMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                    + "accumulative", String.class);
            method.invoke(lowMonthExcelPo, indicatorsDto.getAccumulation() == null ? "" : indicatorsDto.getAccumulation().toString());

            Method method1 = lowMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                            + indicatorsDto.getMonth(),
                    String.class);
            method1.invoke(lowMonthExcelPo, indicatorsDto.getCompletionValue());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return lowMonthExcelPo;
    }

    @Override
    public Set<String> excludeHead(Set<String> excludeHeads, Set<String> months) {
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> keySet = CacheMap.MONTH_MAP.keySet();
        Set<String> strings = new HashSet<>(keySet);
        strings.removeAll(months);
        return getHeads(excludeHeads, strings);
    }

    @Override
    public Set<String> includeHead(Set<String> includeHeads, Set<String> months) {
        return getHeads(includeHeads, months);
    }

    private Set<String> getHeads(Set<String> heads, Set<String> months) {
        months.forEach(month -> {
            heads.add(CompanyEnum.LIAN_CHENG_200.getShortName() + month);
            heads.add(CompanyEnum.QING_HAI_180.getShortName() + month);
            heads.add(CompanyEnum.QING_HAI_200.getShortName() + month);
            heads.add(CompanyEnum.QING_HAI_240.getShortName() + month);
            heads.add(CompanyEnum.LAN_ZHOU_200.getShortName() + month);
            heads.add(CompanyEnum.BAO_TOU_200.getShortName() + month);
            heads.add(CompanyEnum.BAO_TOU_240.getShortName() + month);
        });
        return heads;
    }
}
