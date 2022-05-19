package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.common.CacheMap;
import com.zhonglv.benchmarking.common.CompanyEnum;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillCellMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFreezeStrategy;
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
public class SuperExcelDefaultDataHandler extends SuperExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        Map<String, SuperExcelPo> superExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    SuperExcelPo superExcelPo = superExcelPoMap.get(iNumber);
                    if (superExcelPo == null) {
                        superExcelPo = new SuperExcelPo();
                        assemblyData(stringListEntry.getKey(), superExcelPo, indicatorsDto);
                        superExcelPoMap.put(iNumber, superExcelPo);
                    } else {
                        assemblyData(stringListEntry.getKey(), superExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(superExcelPoMap.values());
    }

    /**
     * 组装数据处理
     *
     * @param companyName   companyName
     * @param superExcelPo  superExcelPo
     * @param indicatorsDto indicatorsDto
     */
    public static void assemblyData(String companyName, SuperExcelPo superExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(superExcelPo, indicatorsDto);
    }

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
        int[] integers = {11, 15};
        registerHandler(write, integers);
    }

    static void registerHandler(ExcelWriterBuilder write, int[] integers) {
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 1));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 2));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 10));
        write.registerWriteHandler(new ExcelFillRowMergeStrategy(3, 14));
        write.registerWriteHandler(new ExcelFreezeStrategy(0, 3, 0, 3));
        write.registerWriteHandler(new ExcelFillCellMergeStrategy(3, integers));
    }

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyMonthExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<MonthExcelPo> excelPoList) {
        Map<String, SuperMonthExcelPo> superMonthExcelPoMap = new LinkedHashMap<>(128);
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    IndicatorsDto indicatorsDto = stringListEntry.getValue().get(i);
                    String iNumber = indicatorsDto.getINumber();
                    SuperMonthExcelPo superMonthExcelPo = superMonthExcelPoMap.get(iNumber);
                    if (superMonthExcelPo == null) {
                        superMonthExcelPo = new SuperMonthExcelPo();
                        dataProcessing(stringListEntry.getKey(), superMonthExcelPo, indicatorsDto);
                        superMonthExcelPoMap.put(iNumber, superMonthExcelPo);
                    } else {
                        dataProcessing(stringListEntry.getKey(), superMonthExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(superMonthExcelPoMap.values());
    }

    /**
     * 数据处理
     *
     * @param superMonthExcelPo mediumMonthExcelPo
     * @param indicatorsDto     indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public MonthExcelPo dataProcessing(String companyName, SuperMonthExcelPo superMonthExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(superMonthExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, superMonthExcelPo);
            superMonthExcelPo.setNumber(indicatorsDto.getINumber());
        }
        try {
            Method method = superMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                    + "accumulative", String.class);
            method.invoke(superMonthExcelPo, indicatorsDto.getAccumulation() == null ? "" : indicatorsDto.getAccumulation().toString());

            Method method1 = superMonthExcelPo.getClass().getDeclaredMethod("set" + CompanyEnum.getCapitalName(companyName)
                            + indicatorsDto.getMonth(),
                    String.class);
            method1.invoke(superMonthExcelPo, indicatorsDto.getCompletionValue());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return superMonthExcelPo;
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
            heads.add(CompanyEnum.SHANG_XI_ZHONG_RUN_500.getShortName() + month);
            heads.add(CompanyEnum.HUA_YUN_500.getShortName() + month);
            heads.add(CompanyEnum.LIAN_CHENG_500.getShortName() + month);
        });
        return heads;
    }
}
