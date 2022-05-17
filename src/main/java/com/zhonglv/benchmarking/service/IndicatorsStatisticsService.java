package com.zhonglv.benchmarking.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.domain.entity.IndicatorsStatistics;


/**
 * @description:
 * @author: Yang Jian
 * @time: 2022/5/16 18:19
 */
public interface IndicatorsStatisticsService extends IService<IndicatorsStatistics> {
    /**
     * 删除
     *
     * @param wrapper wrapper
     * @return Integer
     */
    Integer delete(Wrapper<IndicatorsStatistics> wrapper);
}
