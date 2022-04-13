package com.zhonglv.benchmarking.domain.entity.dto;

import com.zhonglv.benchmarking.domain.entity.Indicators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系列dto数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsDto extends Indicators {
  @ApiModelProperty(value = "标准差")
  private String standardDeviation;

  @ApiModelProperty(value = "横坐标月份")
  private String abscissa;
}
