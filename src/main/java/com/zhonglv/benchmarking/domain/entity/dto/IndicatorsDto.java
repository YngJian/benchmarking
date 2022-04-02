package com.zhonglv.benchmarking.domain.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系列数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsDto extends Indicators {
  @ApiModelProperty(value = "标准差")
  private String standardDeviation;

  @ApiModelProperty(value = "横坐标月份")
  private String abscissa;
}
