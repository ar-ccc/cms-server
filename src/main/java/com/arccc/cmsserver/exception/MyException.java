package com.arccc.cmsserver.exception;

/**
 * 异常类
 */
public class MyException extends RuntimeException{

    private final ExceptionEnum exceptionEnum;

    public MyException(ExceptionEnum exceptionEnum){
        this.exceptionEnum=exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
