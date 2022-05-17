package com.zhonglv.benchmarking.domain.entity.po.single;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <h3>benchmarking</h3>
 * <p>综合能力指数</p>
 *
 * @author : Yang Jian
 * @date : 2022/4/4 16:48
 */
@ApiModel(value = "系列标准差数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ComprehensiveIndex {
    @ApiModelProperty(value = "横坐标月份")
    private String abscissa;

    @ApiModelProperty(value = "时间")
    private String dateMouth;

    @ApiModelProperty(value = "综合指数")
    private String comprehensiveIndex;

    @ApiModelProperty(value = "标准综合指数")
    private String standardComprehensiveIndex;
}
