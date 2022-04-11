package com.zhonglv.benchmarking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.entity.po.IndicatorsPo;

import javax.servlet.http.HttpServletResponse;

public interface IndicatorsService extends IService<Indicators> {

    /**
     * 获取系列数据
     *
     * @param token           token
     * @param seriesNames     seriesNames
     * @param indicatorsNames indicatorsNames
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    Result<IndicatorsPo> getIndicators(String token, String seriesNames, String indicatorsNames, String startTime, String endTime);

    /**
     * 获取系列数据
     *
     * @param token           token
     * @param indicatorsNames indicatorsNames
     * @param seriesType      seriesType
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    Result<IndicatorsPo> getIndicatorsByType(String token, String indicatorsNames, String seriesType, String startTime, String endTime);

    /**
     * download
     *
     * @param token      token
     * @param seriesName seriesName
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    void download(String token, String seriesName, String startTime, String endTime,
                  HttpServletResponse response);

    /**
     * download
     *
     * @param token      token
     * @param seriesType seriesType
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    void downloadBySeriesType(String token, String seriesType, String startTime, String endTime,
                              HttpServletResponse response);
}

