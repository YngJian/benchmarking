package com.zhonglv.benchmarking.controller;

import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.CommonResponse;
import com.zhonglv.benchmarking.service.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author yangj
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @UnLoginLimit
    @PostMapping("/login")
    public CommonResponse login(
            @NotBlank(message = "userName不能为空") String userName,
            @NotBlank(message = "password不能为空") String password) {
        return userInfoService.login(userName, password);
    }

}
