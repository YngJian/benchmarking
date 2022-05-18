package com.zhonglv.benchmarking.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 指标统计表
 */
@ApiModel(value = "指标统计表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_indicators_statistics")
public class IndicatorsStatistics {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 系列名
     */
    @TableField(value = "series_name")
    @ApiModelProperty(value = "系列名")
    private String seriesName;

    /**
     * 指标名
     */
    @TableField(value = "indicators_name")
    @ApiModelProperty(value = "指标名")
    private String indicatorsName;

    /**
     * 工序分类
     */
    @TableField(value = "working_procedure_classification")
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 累计平均
     */
    @TableField(value = "accumulation")
    @ApiModelProperty(value = "累计平均")
    private BigDecimal accumulation;

    /**
     * 年份
     */
    @TableField(value = "`year`")
    @ApiModelProperty(value = "年份")
    private String year;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}