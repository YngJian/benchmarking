package com.zhonglv.benchmarking.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.Indicators;
import com.zhonglv.benchmarking.domain.entity.po.single.IndicatorsPo;

import javax.servlet.http.HttpServletResponse;

public interface IndicatorsService extends IService<Indicators> {

    /**
     * 获取系列数据
     *
     * @param seriesNames     seriesNames
     * @param indicatorsNames indicatorsNames
     * @param countYear       countYear
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    Result<IndicatorsPo> getIndicators(String seriesNames, String indicatorsNames, String countYear,
                                       String startTime, String endTime);

    /**
     * 获取系列数据
     *
     * @param indicatorsNames indicatorsNames
     * @param seriesType      seriesType
     * @param countYear       countYear
     * @param startTime       startTime
     * @param endTime         endTime
     * @return CommonResponse
     */
    Result<IndicatorsPo> getIndicatorsByType(String indicatorsNames, String seriesType, String countYear,
                                             String startTime, String endTime);

    /**
     * download
     *
     * @param token      token
     * @param seriesName seriesName
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    void download(String seriesName, String startTime, String endTime, HttpServletResponse response);

    /**
     * download
     *
     * @param token      token
     * @param seriesType seriesType
     * @param startTime  startTime
     * @param endTime    endTime
     * @param response   response
     */
    void downloadCountByType(String seriesType, String startTime, String endTime, HttpServletResponse response);

    /**
     * 指标统计平均累计值
     *
     * @param seriesName seriesName
     * @param year       year
     * @return Result
     */
    Result<Object> cumulativeValue(String seriesName, String year);

    /**
     * 按类型导出每月累计值
     *
     * @param seriesType seriesType
     * @param countYear  countYear
     * @param response   response
     */
    void downloadCountByType(String seriesType, String countYear, HttpServletResponse response);
}

