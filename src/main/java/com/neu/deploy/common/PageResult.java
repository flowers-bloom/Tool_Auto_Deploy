package com.neu.deploy.common;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author neuq-xjh
 * @Date 2020/7/20
 * @Description 分页结果
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    /**
     * 数据库总记录数
     */
    private long total;

    /**
     * 当前页数据集
     */
    private List<T> rows;
}
