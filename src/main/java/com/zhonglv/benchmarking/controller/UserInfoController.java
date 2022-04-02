package com.zhonglv.benchmarking.controller;

import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.dto.LoginDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserDto;
import com.zhonglv.benchmarking.service.impl.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @UnLoginLimit
    @PostMapping("/login")
    public Result<UserDto> login(@RequestBody @Valid @NotNull LoginDto loginDto) {
        String userName = loginDto.getUserName();
        String password = loginDto.getPassword();
        return userInfoService.login(userName, password);
    }

}
