package com.zhonglv.benchmarking.domain.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.entity.UserGroup;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author yangj
 */
@ApiModel(value = "用户信息表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 组id（id为1的包含所有数据系列权限）
     */
    @ApiModelProperty(value = "组id（id为1的包含所有数据系列权限）")
    private Long groupId;

    /**
     * 是否能上传0不能1能
     */
    @ApiModelProperty(value = "是否能上传0不能1能")
    private Short isUpload;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String userDesc;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "用户组")
    private UserGroup userGroup;

    @ApiModelProperty(value = "系列列表")
    private List<SeriesInfo> seriesInfoList;
}
