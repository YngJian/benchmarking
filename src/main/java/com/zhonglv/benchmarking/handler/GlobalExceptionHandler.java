package com.zhonglv.benchmarking.handler;

import com.zhonglv.benchmarking.common.CommonResult;
import com.zhonglv.benchmarking.common.Result;
import com.zhonglv.benchmarking.exception.UnLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : Yang Jian
 * @date : 2021/6/30 0030 21:46
 */
@Configuration
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<Object> myExceptionHandle(Exception exception) {
        log.error(exception.getMessage(), exception);
        BindingResult result = null;
        if (exception instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException) exception).getBindingResult();
        } else if (exception instanceof BindException) {
            result = ((BindException) exception).getBindingResult();
        } else if (exception instanceof UnLoginException) {
            return new Result<Object>(HttpStatus.FORBIDDEN.value(), exception.getMessage(),null);
        }

        if (result == null) {
            return new Result<>().toFailed();
        }

        StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error ->
                    errorMsg.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("!"));
        }
        return new Result<>().toFailed(errorMsg.toString());
    }

}
