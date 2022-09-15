package com.arccc.cmsserver.exception;

/**
 * 全局异常类
 * 10 用户类
 *       1000     用户名已存在
 *       1001     用户名或密码错误
 *       1002     用户未登录或授权时间已到
 * 90 其他异常
 */
public enum ExceptionEnum {
    USERNAME_EXIST(1000,"用户已存在"),USERNAME_OR_PASSWORD_ERROR(1001,"用户名或密码错误"),
    USER_NOT_LOGIN(1002,"请重新登录")
    ;
    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.msg=msg;
        this.code= code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
