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
public class HuaYun500Handler extends SuperExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
        superExcelDto.setHuaYun500CompletionValue(indicatorsDto.getCompletionValue())
                .setHuaYun500SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setHuaYun500SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setHuaYun500ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return superExcelDto;
    }
}
