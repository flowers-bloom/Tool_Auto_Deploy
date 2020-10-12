package com.neu.deploy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: treblez
 * @Date: 2020/10/11 18:55
 */
@Data
@AllArgsConstructor
public class Repository {
    @NotNull
    String localRepositoryName;
    @NotNull
    String githubRepositoryName;
    @NotNull
    String compileType;
    @NotNull
    List<String> permissionUser;
    @NotNull
    String compileScriptPath;
    @NotNull
    String staticFilePath;

    String repositoryPath;
    Long repositoryId;
    String repositoryVersion;
}
