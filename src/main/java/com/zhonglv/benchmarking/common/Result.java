package com.zhonglv.benchmarking.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "通用返回model")
@Slf4j
public class Result<T> {
    @ApiModelProperty(value = "服务器返回状态码", name = "code", example = "200", required = true)
    private Integer code;

    @ApiModelProperty(value = "服务状态码中文说明", name = "msg", example = "成功", required = true)
    private String msg;

    private T data;


    public Result<T> toSuccess() {
        return new Result<T>().setCode(CommonResult.SUCCESS.getCode()).setMsg(CommonResult.SUCCESS.getMsg());
    }

    public Result<T> toSuccess(T t) {
        return new Result<T>().setCode(CommonResult.SUCCESS.getCode()).setMsg(CommonResult.SUCCESS.getMsg()).setData(t);
    }

    public Result<T> toFailed(String msg) {
        return new Result<T>().setCode(CommonResult.FAILED.getCode()).setMsg(msg);
    }

    public Result<T> toInvalidParam(String msg) {
        return new Result<T>().setCode(CommonResult.INVALID_PARAM.getCode()).setMsg(msg);
    }

    public Result<T> toFailed() {
        return new Result<T>().setCode(CommonResult.FAILED.getCode()).setMsg(CommonResult.FAILED.getMsg());
    }

    /**
     * 无需转发，直接返回Response信息
     */
    public static void responseError(ServletResponse resp, String data) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        ServletOutputStream out = null;
        try {
            out = httpServletResponse.getOutputStream();
            out.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
