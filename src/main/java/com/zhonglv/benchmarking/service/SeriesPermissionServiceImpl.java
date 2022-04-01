package com.zhonglv.benchmarking.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.domain.entity.SeriesPermission;
import com.zhonglv.benchmarking.domain.mapper.SeriesPermissionMapper;
import com.zhonglv.benchmarking.service.impl.SeriesPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SeriesPermissionServiceImpl extends ServiceImpl<SeriesPermissionMapper, SeriesPermission> implements SeriesPermissionService {

}
