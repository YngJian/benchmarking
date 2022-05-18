package com.zhonglv.benchmarking.controller;

import com.alibaba.fastjson.JSON;
import com.zhonglv.benchmarking.annotations.UnLoginLimit;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.po.accumulate.MonthExcelPo;
import com.zhonglv.benchmarking.domain.entity.po.single.IndicatorsPo;
import com.zhonglv.benchmarking.service.IndicatorsService;
import com.zhonglv.benchmarking.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author yangj
 */
@RestController
@RequestMapping("/indicators")
@Slf4j
@Api("系列数据相关API")
public class IndicatorsController {
    private static final String DATE_PATTEN = "yyyy-MM";

    @Autowired
    private IndicatorsService indicatorsService;

    @ApiOperation("系列--获取系列数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", dataType = "String", dataTypeClass = String.class, paramType = "Header"),
            @ApiImplicitParam(name = "seriesNames", value = "所拥有的权限系列,多个以逗号隔开", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "indicatorsNames", value = "指标名称,多个以逗号隔开", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "countYear", value = "需要统计年份", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("/")
    public Result<IndicatorsPo> getIndicators(@RequestHeader @NotBlank(message = "token 不能为空") String token,
                                              @RequestParam(required = false, value = "seriesNames") String seriesNames,
                                              @RequestParam(required = false, value = "indicatorsNames") String indicatorsNames,
                                              @RequestParam(required = false, value = "countYear") String countYear,
                                              @RequestParam(required = false) String startTime,
                                              @RequestParam(required = false) String endTime) {
        if (!DateUtils.correctDateParam(DATE_PATTEN, startTime, endTime)) {
            log.info("Invalid time parameter.startProTime:{},endProTime:{}", startTime, endTime);
            return new Result<IndicatorsPo>().toInvalidParam("Invalid time parameter.");
        }
        if (StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            String defaultTime = DateUtils.getIntervalMonthTime(LocalDate.now(), DATE_PATTEN, 1);
            startTime = defaultTime;
            endTime = defaultTime;
        }
        return indicatorsService.getIndicators(seriesNames, indicatorsNames, countYear, startTime, endTime);
    }

    @ApiOperation("系列--根据系类类型获取数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", dataType = "String", dataTypeClass = String.class, paramType = "Header"),
            @ApiImplicitParam(name = "seriesType", value = "系类类型", allowableValues = "1,2,3", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "indicatorsNames", value = "指标名称,多个以逗号隔开", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "countYear", value = "需要统计年份", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("/type")
    public Result<IndicatorsPo> getIndicatorsByType(@RequestHeader @NotBlank(message = "token 不能为空") String token,
                                                    @RequestParam(required = false, value = "seriesType") String seriesType,
                                                    @RequestParam(required = false, value = "indicatorsNames") String indicatorsNames,
                                                    @RequestParam(required = false, value = "countYear") String countYear,
                                                    @RequestParam(required = false) String startTime,
                                                    @RequestParam(required = false) String endTime) {
        if (!DateUtils.correctDateParam(DATE_PATTEN, startTime, endTime)) {
            log.info("Invalid time parameter.startProTime:{},endProTime:{}", startTime, endTime);
            return new Result<IndicatorsPo>().toInvalidParam("Invalid time parameter.");
        }
        if (StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            String defaultTime = DateUtils.getIntervalMonthTime(LocalDate.now(), DATE_PATTEN, 1);
            startTime = defaultTime;
            endTime = defaultTime;
        }
        return indicatorsService.getIndicatorsByType(indicatorsNames, seriesType, countYear, startTime, endTime);
    }

    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */

    @ApiOperation("系列--导出权限内系列数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "seriesName", value = "系类名称名称", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("download")
    public void download(@RequestParam(value = "seriesName") String seriesName,
                         @RequestParam(required = false) String startTime,
                         @RequestParam(required = false) String endTime,
                         HttpServletResponse response) {
        if (!DateUtils.correctDateParam(DATE_PATTEN, startTime, endTime)) {
            log.info("Invalid time parameter.startProTime:{},endProTime:{}", startTime, endTime);
            Result<IndicatorsPo> result = new Result<IndicatorsPo>().toInvalidParam("Invalid time parameter.");
            Result.responseError(response, JSON.toJSONString(result));
            return;
        }
        if (StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            String defaultTime = DateUtils.getIntervalMonthTime(LocalDate.now(), DATE_PATTEN, 1);
            startTime = defaultTime;
            endTime = defaultTime;
        }
        indicatorsService.download(seriesName, startTime, endTime, response);
    }

    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */

    @ApiOperation("系列--根据系列类型导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "seriesType", value = "系类类型", allowableValues = "1,2,3", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("download/type")
    public void downloadBySeriesType(@RequestParam(value = "seriesType") String seriesType,
                                     @RequestParam(required = false) String startTime,
                                     @RequestParam(required = false) String endTime,
                                     HttpServletResponse response) throws IOException {
        if (!DateUtils.correctDateParam(DATE_PATTEN, startTime, endTime)) {
            log.info("Invalid time parameter.startProTime:{},endProTime:{}", startTime, endTime);
            Result<IndicatorsPo> result = new Result<IndicatorsPo>().toInvalidParam("Invalid time parameter.");
            Result.responseError(response, JSON.toJSONString(result));
            return;
        }
        if (StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)) {
            String defaultTime = DateUtils.getIntervalMonthTime(LocalDate.now(), DATE_PATTEN, 1);
            startTime = defaultTime;
            endTime = defaultTime;
        }
        indicatorsService.downloadCountByType(seriesType, startTime, endTime, response);
    }

    /**
     * 指标统计平均累计值
     *
     * @since 2.1.1
     */
    @ApiOperation("累计--指标统计平均累计值")
    @Tag(name = "累计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "seriesName", value = "seriesName", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "year", value = "year", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @UnLoginLimit
    @GetMapping("statistical")
    public Result<Object> cumulativeValue(@RequestParam(value = "seriesName") String seriesName,
                                          @RequestParam(value = "year") String year) {
        return indicatorsService.cumulativeValue(seriesName, year);
    }

    /**
     * 指标统计平均累计值
     *
     * @since 2.1.1
     */

    @ApiOperation("累计--获取平均累计值列表")
    @Tag(name = "累计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countYear", value = "统计年份", dataType = "String", dataTypeClass = String.class, paramType = "Header"),
            @ApiImplicitParam(name = "seriesType", value = "系类类型", allowableValues = "1,2,3", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("statistical/list")
    public Result<List<MonthExcelPo>> getCumulativeValue(@RequestParam(value = "seriesType") String seriesType,
                                                         @RequestParam(value = "countYear") String countYear) {
        return indicatorsService.getCumulativeValue(seriesType, countYear);
    }

    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     *
     * @since 2.1.1
     */

    @ApiOperation("累计--按类型导出每月累计值")
    @Tag(name = "累计")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countYear", value = "统计年份", dataType = "String", dataTypeClass = String.class, paramType = "Header"),
            @ApiImplicitParam(name = "seriesType", value = "系类类型", allowableValues = "1,2,3", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("download/cumulative")
    public void downloadCountByType(@RequestParam(value = "seriesType") String seriesType,
                                    @RequestParam(value = "countYear") String countYear,
                                    HttpServletResponse response) {
        indicatorsService.downloadCountByType(seriesType, countYear, response);
    }
}
