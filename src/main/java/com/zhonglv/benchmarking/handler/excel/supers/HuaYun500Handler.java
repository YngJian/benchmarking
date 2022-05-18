package com.zhonglv.benchmarking.handler.excel.supers;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;
import com.zhonglv.benchmarking.handler.excel.SuperExcelDataHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/4/11 14:32
 */
@Slf4j
public class HuaYun500Handler extends SuperExcelDataHandler {
    /**
     * 数据处理
     *
     * @param indicatorsDto indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public ExcelPo dataProcessing(SuperExcelPo superExcelDto, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(superExcelDto.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, superExcelDto);
            superExcelDto.setNumber(indicatorsDto.getINumber());
        }
        superExcelDto.setHuaYun500CompletionValue(indicatorsDto.getCompletionValue())
                .setHuaYun500SingleIndexCapabilityIndex(indicatorsDto.getSingleIndexCapabilityIndex())
                .setHuaYun500SeriesComprehensiveCapabilityIndex(indicatorsDto.getSeriesComprehensiveCapabilityIndex())
                .setHuaYun500ProcessComprehensiveCapabilityIndex(indicatorsDto.getProcessComprehensiveCapabilityIndex());
        return superExcelDto;
    }
}
