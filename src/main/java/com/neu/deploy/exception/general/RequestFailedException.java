package com.neu.deploy.exception.general;

import com.neu.deploy.exception.BaseException;

/**
 * @Author: treblez
 * @Date: 2020/10/12 19:51
 */
public class RequestFailedException extends BaseException {
    public RequestFailedException(String message) {
        super(100005, message);
    }
}
