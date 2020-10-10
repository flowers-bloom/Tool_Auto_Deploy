package com.neu.deploy.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author neuq-xjh
 * @Date 2020/8/12
 * @Description 统一响应类
 */
@Data
@AllArgsConstructor
@ApiModel(value = "Result", description = "统一响应类")
public class Result {
    @ApiModelProperty(value = "请求是否成功", example = "true")
    private boolean flag;

    @ApiModelProperty(value = "状态码", example = "0")
    private int code;

    @ApiModelProperty(value = "返回消息", example = "请求成功")
    private String message;

    @ApiModelProperty(value = "返回数据", example = "{}")
    private Object data;
}
