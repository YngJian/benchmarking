package com.zhonglv.benchmarking.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author yangj
 */
public class CommonResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public CommonResponse code(HttpStatus status) {
        put("code", status.value());
        return this;
    }

    public CommonResponse success(HttpStatus status, String msg) {
        put("code", status.value());
        put("msg", msg);
        return this;
    }

    public CommonResponse message(String message) {
        put("msg", message);
        return this;
    }

    public CommonResponse data(Object data) {
        put("data", data);
        return this;
    }

    public CommonResponse success() {
        code(HttpStatus.OK);
        return this;
    }

    public CommonResponse fail() {
        code(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    public CommonResponse fail(String msg) {
        code(HttpStatus.INTERNAL_SERVER_ERROR);
        put("msg", msg);
        return this;
    }

    @Override
    public CommonResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
