package com.zhonglv.benchmarking.handler.excel.supers;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.SuperMonthExcelPo;
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
public class ShanXi500Handler extends SuperExcelDataHandler {
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
            Method method = superMonthExcelPo.getClass().getDeclaredMethod("setShanXi500accumulative", BigDecimal.class);
            method.invoke(superMonthExcelPo, indicatorsDto.getAccumulation());

            Method method1 = superMonthExcelPo.getClass().getDeclaredMethod("setShanXi500" + indicatorsDto.getMonth(),
                    String.class);
            method1.invoke(superMonthExcelPo, indicatorsDto.getCompletionValue());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }
        return superMonthExcelPo;
    }
}
