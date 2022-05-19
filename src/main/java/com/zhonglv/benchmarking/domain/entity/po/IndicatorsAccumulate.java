package com.zhonglv.benchmarking.domain.entity.po;

import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/5/19 11:25
 */
@Data
@Accessors(chain = true)
public class IndicatorsAccumulate {
    @ApiModelProperty(value = "值")
    private List<MonthExcelPo> monthExcelPoList;

    @ApiModelProperty(value = "属性集合")
    private Set<String> propertyList;
}
