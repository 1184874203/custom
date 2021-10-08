package com.custom.constants;

/**
 * @author: 邵禹寒
 * @date: 2021-09-23 16:20
 */
public enum ExceptionEnum {
    AGE_EXCEPTION(100,"年龄不能小于0！"),
    LOGIN_EXCEPTION(101,"用户名或密码错误！"),
    TOKEN_EXCEPTION(102,"没有传入token！"),
    TOKEN_MISSING(103,"请先登录！");

    public Integer code;
    public String msg;
    ExceptionEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
