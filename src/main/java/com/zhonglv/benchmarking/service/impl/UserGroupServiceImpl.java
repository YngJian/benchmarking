package com.zhonglv.benchmarking.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.domain.entity.UserGroup;
import com.zhonglv.benchmarking.domain.mapper.UserGroupMapper;
import com.zhonglv.benchmarking.service.UserGroupService;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {

}
