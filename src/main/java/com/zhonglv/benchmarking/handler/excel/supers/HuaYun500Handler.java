package com.zhonglv.benchmarking.handler.excel.supers;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.ExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.SuperExcelPo;
import com.zhonglv.benchmarking.handler.excel.SuperExcelDataHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

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

    /**
     * 数据处理
     *
     * @param superMonthExcelPo superMonthExcelPo
     * @param indicatorsDto     indicatorsDto
     * @return ExcelPo ExcelPo
     */
    @Override
    public MonthExcelPo dataProcessing(SuperMonthExcelPo superMonthExcelPo, IndicatorsDto indicatorsDto) {
        if (StringUtils.isBlank(superMonthExcelPo.getNumber())) {
            BeanUtils.copyProperties(indicatorsDto, superMonthExcelPo);
            superMonthExcelPo.setNumber(indicatorsDto.getINumber());
        }
        try {
            Method method = superMonthExcelPo.getClass().getDeclaredMethod("setHuaYun500accumulative", BigDecimal.class);
            method.invoke(superMonthExcelPo, indicatorsDto.getAccumulation());

            Method method1 = superMonthExcelPo.getClass().getDeclaredMethod("setHuaYun500" + indicatorsDto.getMonth(),
                    String.class);
            method1.invoke(superMonthExcelPo, indicatorsDto.getCompletionValue());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return superMonthExcelPo;
    }
}
