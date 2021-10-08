package com.custom.constants;

import lombok.Data;

/**
 * @author: 邵禹寒
 * @date: 2021-09-23 16:23
 */
@Data
public class MyException extends Exception {
    private ExceptionEnum exceptionEnum;
    private Integer code;
    private String msg;

    public MyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
        this.code = exceptionEnum.code;
        this.msg = exceptionEnum.msg;
    }
}
