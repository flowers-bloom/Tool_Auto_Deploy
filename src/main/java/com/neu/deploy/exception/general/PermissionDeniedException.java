package com.neu.deploy.exception.general;

import com.neu.deploy.exception.BaseException;

/**
 * @Author: treblez
 * @Date: 2020/10/11 19:18
 */
public class PermissionDeniedException extends BaseException {
    public PermissionDeniedException(String message){
        super(100000,message);
    }
}
