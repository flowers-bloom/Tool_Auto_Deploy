package com.neu.deploy.controller;

import com.neu.deploy.common.Result;
import com.neu.deploy.common.StatusCode;
import com.neu.deploy.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lzs
 * @date 2020/10/10 19:18
 * @description
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{code}")
    @ApiOperation(value = "获取AccessToken")
    public Result getAccessToken(@PathVariable("code") String code) {
        userService.getAccessToken(code);

        return new Result(true, StatusCode.OK, "请求成功", null);
    }
}