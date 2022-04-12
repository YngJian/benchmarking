package com.zhonglv.benchmarking.handler.excel;

import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.SuperExcelPo;

import java.util.List;
import java.util.Map;

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
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {

    }

    /**
     * 数据处理
     *
     * @param write write
     */
    @Override
    public void writeExcelHandle(ExcelWriterBuilder write) {
    }
}
