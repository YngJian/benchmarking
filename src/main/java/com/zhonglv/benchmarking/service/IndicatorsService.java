package com.zhonglv.benchmarking.service;

import com.zhonglv.benchmarking.common.CommonResponse;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IndicatorsService extends IService<Indicators> {

    /**
     * 获取系列数据
     *
     * @param token       token
     * @param seriesNames seriesNames
     * @return CommonResponse
     */
    CommonResponse getIndicators(String token, List<String> seriesNames);
}

