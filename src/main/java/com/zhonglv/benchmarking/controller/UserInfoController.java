package com.zhonglv.benchmarking.controller;

import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.CommonResponse;
import com.zhonglv.benchmarking.service.impl.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author yangj
 */
@RestController
@RequestMapping("/user")
@Api("登陆相关API")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @UnLoginLimit
    @PostMapping("/login")
    public CommonResponse login(
            @NotBlank(message = "userName不能为空") String userName,
            @NotBlank(message = "password不能为空") String password) {
        return userInfoService.login(userName, password);
    }

}
