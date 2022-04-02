package com.zhonglv.benchmarking.common;

/**
 * @author yangj
 */
public enum CommonResult {
  SUCCESS(200, "success"),
  FAILED(500, "failed"),
  UN_LOGIN(403, "unlogin"),
  INVALID_PARAM(600, "invalid param");

  private final Integer code;
  private final String msg;

  CommonResult(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
