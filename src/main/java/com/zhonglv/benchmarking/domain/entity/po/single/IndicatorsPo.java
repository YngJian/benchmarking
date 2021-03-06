package com.zhonglv.benchmarking.domain.entity.po.single;

import com.zhonglv.benchmarking.domain.entity.dto.IndicatorsDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@ApiModel(value = "系列返回数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IndicatorsPo {
    @ApiModelProperty(value = "系列数据")
    private Map<String, List<IndicatorsDto>> indicatorsMap;

    @ApiModelProperty(value = "按月的综合系数")
    private Map<String, List<ComprehensiveIndex>> indexMap;

    @ApiModelProperty(value = "按月按指标时间数据")
    private Map<String, Map<String, List<IndicatorsDto>>> indicesMap;

    @ApiModelProperty(value = "excel的合并数据")
    private List<ExcelPo> excelPoList;
}
