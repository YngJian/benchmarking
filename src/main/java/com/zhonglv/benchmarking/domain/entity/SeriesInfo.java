package com.zhonglv.benchmarking.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 系列信息
 *
 * @author yangj
 */
@ApiModel(value = "系列信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_series_info")
public class SeriesInfo {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系类信息
     */
    @TableField(value = "info")
    @ApiModelProperty(value = "系类信息")
    private String info;

    /**
     * 分公司
     */
    @TableField(value = "electrolytic_series")
    @ApiModelProperty(value = "分公司")
    private String electrolyticSeries;

    /**
     * 系列
     */
    @TableField(value = "branch_company")
    @ApiModelProperty(value = "系列")
    private String branchCompany;

    /**
     * 系类所属类型1：500kA指标系类 2：300-400kA指标系类 3： 240kA及以下指标系类
     */
    @TableField(value = "series_type")
    @ApiModelProperty(value = "系类所属类型1：500kA指标系类 2：300-400kA指标系类 3： 240kA及以下指标系类")
    private Short seriesType;

    /**
     * 描述
     */
    @TableField(value = "series_desc")
    @ApiModelProperty(value = "描述")
    private String seriesDesc;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}