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
public class BaoTou200Handler extends LowExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        lowExcelPo.setBaoTou200CompletionValue(indicatorsDto.getCompletionValue())
                .setBaoTou200SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setBaoTou200SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setBaoTou200ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return lowExcelPo;
    }
}
