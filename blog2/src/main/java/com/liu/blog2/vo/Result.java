package com.liu.blog2.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private int code;

    private boolean success;

    private String msg;

    private Object data;


    public static Result success(Object data){
        return new Result(200,true,"success",data);
    }

    public static Result fail(Object data){
        return new Result(400,false,"success",data);
    }

    public static Result fail(int code, String msg) {
        return new Result(code,false,msg,msg);
    }
}
