package com.zhonglv.benchmarking.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.domain.entity.SeriesInfo;
import com.zhonglv.benchmarking.domain.mapper.SeriesInfoMapper;
import com.zhonglv.benchmarking.service.SeriesInfoService;
import org.springframework.stereotype.Service;

@Service
public class SeriesInfoServiceImpl extends ServiceImpl<SeriesInfoMapper, SeriesInfo> implements SeriesInfoService {

}
