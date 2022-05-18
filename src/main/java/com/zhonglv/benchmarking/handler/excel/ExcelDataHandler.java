package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.LowMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MediumMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.LowExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public interface ExcelDataHandler {
    /**
     * 数据处理
     *
     * @param superExcelDto superExcelDto
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
        return superExcelDto;
    }

    /**
     * 数据处理
     *
     * @param companyName       companyName
     * @param superMonthExcelPo superMonthExcelPo
     * @param indicatorsDto     indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default MonthExcelPo dataProcessing(String companyName, SuperMonthExcelPo superMonthExcelPo, IndicatorsDto indicatorsDto) {
        return superMonthExcelPo;
    }

    /**
     * 数据处理
     *
     * @param mediumExcelPo mediumExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
        return mediumExcelPo;
    }

    /**
     * 数据处理
     *
     * @param companyName        companyName
     * @param mediumMonthExcelPo mediumMonthExcelPo
     * @param indicatorsDto      indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default MonthExcelPo dataProcessing(String companyName, MediumMonthExcelPo mediumMonthExcelPo, IndicatorsDto indicatorsDto) {
        return mediumMonthExcelPo;
    }

    /**
     * 数据处理
     *
     * @param lowExcelPo    lowExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        return lowExcelPo;
    }

    /**
     * 数据处理
     *
     * @param companyName     companyName
     * @param lowMonthExcelPo lowMonthExcelPo
     * @param indicatorsDto   indicatorsDto
     * @return ExcelPo ExcelPo
     */
    default MonthExcelPo dataProcessing(String companyName, LowMonthExcelPo lowMonthExcelPo, IndicatorsDto indicatorsDto) {
        return lowMonthExcelPo;
    }

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    void assemblyExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList);

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    void assemblyMonthExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<MonthExcelPo> excelPoList);

    /**
     * 数据处理
     *
     * @param write write
     */
    void writeExcelHandle(ExcelWriterBuilder write);

    Set<String> excludeHead(Set<String> excludeHeads, Set<String> months);
}
