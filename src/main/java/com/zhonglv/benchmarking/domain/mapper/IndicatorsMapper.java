package com.zhonglv.benchmarking.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndicatorsMapper extends BaseMapper<Indicators> {
}