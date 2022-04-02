package com.zhonglv.benchmarking.domain.entity.po;

import com.zhonglv.benchmarking.domain.entity.Indicators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@ApiModel(value = "系列数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IndicatorsPo {
    @ApiModelProperty(value = "系列数据")
    Map<String, List<Indicators>> indicatorsMap;
    @ApiModelProperty(value = "标准数据")
    Map<String, List<Indicators>> standardMap;
}
