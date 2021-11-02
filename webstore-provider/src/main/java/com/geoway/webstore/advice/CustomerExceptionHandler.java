package com.geoway.webstore.advice;

import com.geoway.webstore.comm.Result;
import com.geoway.webstore.comm.ResultCode;
import com.geoway.webstore.comm.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

/**
 * @author Lencho
 * @create 2021-08-18 20:48
 */
@Slf4j
@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result Exception(Exception e) {
        log.error("未知异常！", e);
        return ResultResponse.failure( ResultCode.BAD_REQUEST);
    }
}
