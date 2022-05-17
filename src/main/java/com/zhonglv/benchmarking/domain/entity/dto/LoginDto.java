package com.zhonglv.benchmarking.domain.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author Administrator
 */
@ApiModel(value = "登录信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginDto {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空！", groups = Login.class)
    @ApiModelProperty(value = "用户名(修改时，不必填)", required = true)
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空！", groups = {Login.class, Change.class})
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    public interface Login {
    }

    public interface Change {
    }
}
