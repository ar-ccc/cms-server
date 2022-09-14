package com.arccc.cmsserver.exception;

import com.arccc.cmsserver.utils.Result;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    //本地异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result exception(MyException e){
        return Result.error(e.getExceptionEnum());
    }

    //其他异常
    @ExceptionHandler(Exception.class)
    public Result other(Exception e){
        e.printStackTrace();
        return new Result(9000,e.getMessage());
    }
}
