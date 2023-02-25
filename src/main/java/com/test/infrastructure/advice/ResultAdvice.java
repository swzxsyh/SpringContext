package com.test.infrastructure.advice;


import com.test.infrastructure.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截器
 *
 * @author swzxsyh
 */
@Slf4j
@RestControllerAdvice
public class ResultAdvice {

    @ExceptionHandler(NullPointerException.class)
    public Result nullPointException(NullPointerException ex) {
        log.error("null Point err:", ex);
        return Result.error("NULL POINT ERROR" + ex.getMessage());
    }

    @ExceptionHandler(ClassCastException.class)
    public Result classCastException(ClassCastException ex) {
        log.error("classCastException err:", ex);
        return Result.error("ClassCastException:" + ex.getMessage());
    }

}
