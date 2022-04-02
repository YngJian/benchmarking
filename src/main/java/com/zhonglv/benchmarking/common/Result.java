package com.zhonglv.benchmarking.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "通用返回model")
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
}
