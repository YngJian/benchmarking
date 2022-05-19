package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public abstract class SuperExcelDataHandler implements ExcelDataHandler {
    /**
     * 数据处理
     *
     * @param superExcelDto superExcelDto
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
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
    @Override
    public MonthExcelPo dataProcessing(String companyName, SuperMonthExcelPo superMonthExcelPo, IndicatorsDto indicatorsDto) {
        return superMonthExcelPo;
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
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblyMonthExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<MonthExcelPo> excelPoList) {

    }

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
    }

    @Override
    public Set<String> excludeHead(Set<String> months, Set<String> excludeHeads) {
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
