package com.neu.deploy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: treblez
 * @Date: 2020/10/12 19:04
 * @Description 放HTTP请求响应的实体类
 */
@Data
@AllArgsConstructor
public class HTTPResponse {
    Map<String, List<String>> headers;

    JSONObject body;
}
