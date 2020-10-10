package com.neu.deploy.exception.handler;

import com.neu.deploy.common.Result;
import com.neu.deploy.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @Author neuq-xjh
 * @Date 2019/11/27 0027
 * @Description 异常处理类
 **/
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Result handleController(BaseException e)
    {
        return new Result(true, e.getCode(), e.getMessage(), null);
    }
}
