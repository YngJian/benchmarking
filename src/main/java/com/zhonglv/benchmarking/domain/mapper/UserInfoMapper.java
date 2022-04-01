package com.zhonglv.benchmarking.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonglv.benchmarking.domain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}