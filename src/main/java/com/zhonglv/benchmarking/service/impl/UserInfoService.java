package com.zhonglv.benchmarking.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.common.CommonResponse;
import com.zhonglv.benchmarking.domain.entity.UserInfo;

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
    CommonResponse login(String userName, String password);
}
