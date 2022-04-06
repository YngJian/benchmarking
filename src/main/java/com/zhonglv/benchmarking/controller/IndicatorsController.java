package com.zhonglv.benchmarking.controller;

import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.domain.entity.po.IndicatorsPo;
import com.zhonglv.benchmarking.service.IndicatorsService;
import com.zhonglv.benchmarking.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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

    @ApiOperation("获取系列数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", dataType = "String", dataTypeClass = String.class, paramType = "Header"),
            @ApiImplicitParam(name = "seriesNames", value = "所拥有的权限系列,多个以逗号隔开", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "indicatorsNames", value = "指标名称,多个以逗号隔开", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束生产时间 格式yyyy-MM", dataType = "String", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("/")
    public Result<IndicatorsPo> getIndicators(@RequestHeader @NotBlank(message = "token 不能为空") String token,
                                              @RequestParam(required = false, value = "seriesNames") String seriesNames,
                                              @RequestParam(required = false, value = "indicatorsNames") String indicatorsNames,
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
        return indicatorsService.getIndicators(token, seriesNames, indicatorsNames, startTime, endTime);
    }
}
