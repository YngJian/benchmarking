package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillCellMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;
import com.zhonglv.benchmarking.utils.ExcelFreezeStrategy;

import java.util.*;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
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
                        assemblyMonthData(stringListEntry.getKey(), superMonthExcelPo, indicatorsDto);
                        superMonthExcelPoMap.put(iNumber, superMonthExcelPo);
                    } else {
                        assemblyMonthData(stringListEntry.getKey(), superMonthExcelPo, indicatorsDto);
                    }
                }
            }
        }
        excelPoList.addAll(superMonthExcelPoMap.values());
    }

    /**
     * 组装数据处理
     *
     * @param companyName       companyName
     * @param superMonthExcelPo superMonthExcelPo
     * @param indicatorsDto     indicatorsDto
     */
    public static void assemblyMonthData(String companyName, SuperMonthExcelPo superMonthExcelPo, IndicatorsDto indicatorsDto) {
        Optional<ExcelDataHandler> excelDataHandler = ExcelHandleFactory.getByCompanyName(companyName);
        if (!excelDataHandler.isPresent()) {
            return;
        }
        excelDataHandler.get().dataProcessing(superMonthExcelPo, indicatorsDto);
    }

    @Override
    public Set<String> includeHead(Integer monthCount) {
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> includeColumnFiledNames = new LinkedHashSet<>();
        for (int i = 1; i <= monthCount; i++) {
            if (i < 10) {
                includeColumnFiledNames.add("shanXi500" + "0" + i);
            } else {
                includeColumnFiledNames.add("shanXi500" + i);
            }
        }
        for (int i = 1; i <= monthCount; i++) {
            if (i < 10) {
                includeColumnFiledNames.add("huaYun500" + "0" + i);
            } else {
                includeColumnFiledNames.add("huaYun500" + i);
            }
        }
        for (int i = 1; i <= monthCount; i++) {
            if (i < 10) {
                includeColumnFiledNames.add("lianCheng500" + "0" + i);
            } else {
                includeColumnFiledNames.add("lianCheng500" + i);
            }
        }
        return includeColumnFiledNames;
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
}
