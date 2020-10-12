package com.neu.deploy.exception.general;

import com.neu.deploy.exception.BaseException;

/**
 * @Author: treblez
 * @Date: 2020/10/12 21:00
 */
public class OperationFailedException extends BaseException {
    public OperationFailedException(String message) {
        super(100002, message);
    }
}
