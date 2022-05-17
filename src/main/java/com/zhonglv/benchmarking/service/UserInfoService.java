package com.zhonglv.benchmarking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import com.zhonglv.benchmarking.domain.entity.dto.LoginDto;
import com.zhonglv.benchmarking.domain.entity.dto.UserDto;

/**
 * @author yangj
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * login
     *
     * @param userName userName
     * @param password password
     * @return CommonResponse
     */
    Result<UserDto> login(String userName, String password);

    /**
     * changePassword
     *
     * @param token    token
     * @param loginDto loginDto
     * @return Result
     */
    Result<Object> changePassword(String token, LoginDto loginDto);
}
