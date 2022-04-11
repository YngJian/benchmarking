package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {
        for (Map<String, List<IndicatorsDto>> value : indicesMap.values()) {
            for (Map.Entry<String, List<IndicatorsDto>> stringListEntry : value.entrySet()) {
                LowExcelPo lowExcelPo = new LowExcelPo();
                stringListEntry.getValue().forEach(indicatorsDto -> {
                    assemblyData(stringListEntry.getKey(), lowExcelPo, indicatorsDto);
                });
                excelPoList.add(lowExcelPo);
            }
        }
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
}
