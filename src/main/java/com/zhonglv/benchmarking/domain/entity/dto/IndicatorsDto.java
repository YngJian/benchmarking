package com.zhonglv.benchmarking.domain.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系列数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndicatorsDto extends Indicators {
    private String standardDeviation;
    private String abscissa;
}
