package com.neu.deploy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author neuq-xjh
 * @Date 2019/11/27 0027
 * @Description 异常基类
 **/
@Data
public class BaseException extends Exception {
    private int code;
    private String message;

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
