package com.neu.deploy.dto.request;

import com.neu.deploy.domain.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Map;

/**
 * @Author: treblez
 * @Date: 2020/10/11 18:16
 */
@Data
@AllArgsConstructor
public class RepositoryCreateRequest {
    @NotNull(message = "async不能为空")
    private Boolean async;
    @Pattern(regexp = "^json*|^Json*|^JSON*",message = "不符合指定类型")
    private String dataType;

    Repository repository;
}
