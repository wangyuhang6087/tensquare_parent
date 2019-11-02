package com.zhiyou100.controller;

import com.zhiyou100.util.ResultObject;
import com.zhiyou100.util.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:Rain
 * @date 2019/11/2 11:47
 * @desc
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultObject error(Exception e) {
        e.printStackTrace();
        return  new ResultObject(false, StatusCode.ERROR,e.getMessage());
    }

}