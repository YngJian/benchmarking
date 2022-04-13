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
 * 用户信息表
 *
 * @author yangj
 */
@ApiModel(value = "用户信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user_info")
public class UserInfo {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "pwd")
    @ApiModelProperty(value = "密码")
    private String pwd;

    /**
     * 组id（id为1的包含所有数据系列权限）
     */
    @TableField(value = "group_id")
    @ApiModelProperty(value = "组id（id为1的包含所有数据系列权限）")
    private Long groupId;

    /**
     * 是否能上传0不能1能
     */
    @TableField(value = "is_upload")
    @ApiModelProperty(value = "是否能上传0不能1能")
    private Short isUpload;

    /**
     * 描述
     */
    @TableField(value = "user_desc")
    @ApiModelProperty(value = "描述")
    private String userDesc;

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