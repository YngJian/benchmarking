package com.zhonglv.benchmarking.domain.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@ApiModel(value = "返回用户信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto {
  @ApiModelProperty(value = "用户信息")
  private UserInfoDto userInfoDto;

  @ApiModelProperty(value = "token")
  private String token;
}
