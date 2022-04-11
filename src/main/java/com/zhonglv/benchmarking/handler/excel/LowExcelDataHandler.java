package com.zhonglv.benchmarking.handler.excel;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public abstract class LowExcelDataHandler implements ExcelDataHandler {
    /**
     * 数据处理
     *
     * @param lowExcelPo    lowExcelPo
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto){return lowExcelPo;}

    /**
     * 数据处理
     *
     * @param indicesMap  indicesMap
     * @param excelPoList excelPoList
     */
    @Override
    public void assemblySuperExcel(Map<String, Map<String, List<IndicatorsDto>>> indicesMap, List<ExcelPo> excelPoList) {

    }

}
