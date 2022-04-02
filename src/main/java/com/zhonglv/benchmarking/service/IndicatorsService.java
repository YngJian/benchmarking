package com.zhonglv.benchmarking.service;

import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.domain.entity.po.IndicatorsPo;

public interface IndicatorsService extends IService<Indicators> {

    /**
     * 获取系列数据
     *
     * @param token       token
     * @param seriesNames seriesNames
     * @param startTime startTime
     * @param endTime endTime
     * @return CommonResponse
     */
    Result<IndicatorsPo> getIndicators(String token, String seriesNames, String startTime, String endTime);
}

