package com.zhonglv.benchmarking.handler.excel.supers;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.SuperExcelPo;
import com.zhonglv.benchmarking.handler.excel.SuperExcelDataHandler;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class LianCheng500Handler extends SuperExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
        superExcelDto.setLianCheng500CompletionValue(indicatorsDto.getCompletionValue())
                .setLianCheng500SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setLianCheng500SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setLianCheng500ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return superExcelDto;
    }
}
