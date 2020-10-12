package com.neu.deploy.exception.general;

import com.neu.deploy.exception.BaseException;

/**
 * @Author: treblez
 * @Date: 2020/10/12 9:26
 */
public class ResourceExistedException extends BaseException {

    public ResourceExistedException(String message) {
        super(100004,message);
    }
}
