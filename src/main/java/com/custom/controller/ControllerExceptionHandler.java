package com.custom.controller;

import com.custom.constants.MyException;
import com.custom.constants.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 邵禹寒
 * @date: 2021-09-23 09:31
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MyException.class)
    public Result ExceptionHandler(MyException e) {
        return new Result(e.getCode(), e.getMsg(), null);
    }
}
