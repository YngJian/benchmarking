package com.zhonglv.benchmarking.handler.excel.low;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.LowExcelPo;
import com.zhonglv.benchmarking.handler.excel.LowExcelDataHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
public class QingHai240Handler extends LowExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(LowExcelPo lowExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(lowExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, lowExcelPo);
            lowExcelPo.setNumber(indicatorsDto.getINumber());
        }
        lowExcelPo.setQingHai240CompletionValue(indicatorsDto.getCompletionValue())
                .setQingHai240SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setQingHai240SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setQingHai240ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return lowExcelPo;
    }
}