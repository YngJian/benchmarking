package com.zhonglv.benchmarking.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonglv.benchmarking.domain.entity.IndicatorsStatistics;
import com.zhonglv.benchmarking.domain.mapper.IndicatorsStatisticsMapper;
import com.zhonglv.benchmarking.service.IndicatorsStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/5/16 18:19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class IndicatorsStatisticsServiceImpl extends ServiceImpl<IndicatorsStatisticsMapper, IndicatorsStatistics> implements IndicatorsStatisticsService {
    private final IndicatorsStatisticsMapper indicatorsStatisticsMapper;

    /**
     * 删除
     *
     * @param wrapper wrapper
     * @return Integer
     */
    @Override
    public Integer delete(Wrapper<IndicatorsStatistics> wrapper) {
        return indicatorsStatisticsMapper.delete(wrapper);
    }
}
