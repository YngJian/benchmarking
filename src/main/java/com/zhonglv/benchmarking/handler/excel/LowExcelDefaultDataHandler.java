package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.LowExcelPo;
import com.zhonglv.benchmarking.utils.ExcelFillRowMergeStrategy;

import java.util.*;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
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

    }

    @Override
    public Set<String> includeHead(Integer monthCount) {
        return null;
    }
}
