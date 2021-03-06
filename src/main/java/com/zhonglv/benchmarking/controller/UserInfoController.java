package com.zhonglv.benchmarking.controller;

import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.ConstantType;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.dto.LoginDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserDto;
import com.zhonglv.benchmarking.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation("登陆")
    @UnLoginLimit
    @PostMapping("/login")
    public Result<UserDto> login(@RequestBody @Validated({LoginDto.Login.class}) @NotNull LoginDto loginDto) {
        String userName = loginDto.getUserName();
        String password = loginDto.getPassword();
        return userInfoService.login(userName, password);
    }

    @ApiOperation("登出")
    @PostMapping("/loginout")
    public Result<Object> loginOut(@RequestHeader @NotBlank(message = "token 不能为空") String token) {
        stringRedisTemplate.delete(ConstantType.TOKEN_KEY + token);
        return new Result<>().toSuccess();
    }

    @ApiOperation("修改密码")
    @PostMapping("/password")
    public Result<Object> changePassword(@RequestHeader @NotBlank(message = "token 不能为空") String token,
                                         @RequestBody @Validated({LoginDto.Change.class}) @NotNull LoginDto loginDto) {
        return userInfoService.changePassword(token, loginDto);
    }
}
