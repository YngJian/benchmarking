package com.zhonglv.benchmarking.handler.excel.low;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
import com.zhonglv.benchmarking.handler.excel.LowExcelDataHandler;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class BaoTou240Handler extends LowExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        lowExcelPo.setBaoTou240CompletionValue(indicatorsDto.getCompletionValue())
                .setBaoTou240SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setBaoTou240SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setBaoTou240ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return lowExcelPo;
    }
}
