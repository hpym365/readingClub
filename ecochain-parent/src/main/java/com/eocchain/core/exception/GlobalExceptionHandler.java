package com.eocchain.core.exception;

import com.eocchain.core.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Haben
 * @Description:
 * @Date: 2017-08-25 12:07
 * @Version: 1.0
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    public Result uncaughtExceptionHandler(HttpServletRequest request,
                                           Throwable exception) {
        return Result.failed("未捕获的异常catch by GlobalExceptionHandler uncaughtExceptionHandler"+exception.getMessage());
    }
}
