package com.arccc.cmsserver.utils;

import com.arccc.cmsserver.exception.ExceptionEnum;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public static Result ok(){
        return new Result(200,"ok");
    }
    public static Result ok(String msg){
        return new Result(200,msg);
    }

    public static Result error(ExceptionEnum exceptionEnum){
        return new Result(exceptionEnum.getCode(),exceptionEnum.getMsg());
    }
    public Result data(Object o){
        this.setData(o);
        return this;
    }

}
