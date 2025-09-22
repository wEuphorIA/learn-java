package com.itheima.handler;

import com.itheima.common.DeletionNotAllowedException;
import com.itheima.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/5 上午9:29 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        return Result.error("服务器繁忙，请稍后再试");
    }

    @ExceptionHandler
    public Result handleException(DeletionNotAllowedException e){
        return Result.error(e.getMessage());
    }

}
