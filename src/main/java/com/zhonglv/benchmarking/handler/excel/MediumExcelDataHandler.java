package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MediumMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.MediumExcelPo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public abstract class MediumExcelDataHandler implements ExcelDataHandler {
    /**
     * 数据处理
     *
     * @param mediumExcelPo mediumExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(MediumExcelPo mediumExcelPo, IndicatorsDto indicatorsDto) {
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
    @Override
    public MonthExcelPo dataProcessing(String companyName, MediumMonthExcelPo mediumMonthExcelPo, IndicatorsDto indicatorsDto) {
        return mediumMonthExcelPo;
    }

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {

    }

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
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
    public Set<String> excludeHead(Set<String> excludeHeads, Set<String> months) {
        return new HashSet<>();
    }

    /**
     * includeHead
     *
     * @param includeHeads includeHeads
     * @param months       months
     * @return Set
     */
    @Override
    public Set<String> includeHead(Set<String> includeHeads, Set<String> months) {
        return new HashSet<>();
    }
}
