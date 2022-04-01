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
 * 数据系类权限关联表
 */
@ApiModel(value = "数据系类权限关联表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_series_permission")
public class SeriesPermission {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 用户组id
     */
    @TableField(value = "group_id")
    @ApiModelProperty(value = "用户组id")
    private Integer groupId;

    /**
     * 系列信息id
     */
    @TableField(value = "series_id")
    @ApiModelProperty(value = "系列信息id")
    private Integer seriesId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}