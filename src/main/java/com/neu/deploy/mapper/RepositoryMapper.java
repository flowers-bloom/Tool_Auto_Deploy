package com.neu.deploy.mapper;

import com.neu.deploy.domain.Repository;

import java.util.Collection;

/**
 * @Author: treblez
 * @Date: 2020/10/12 9:13
 */

public interface RepositoryMapper {

    Repository getRepositoryByLocalName(String localName);
    Repository getRepositoryByGitName(String gitName);
    Collection<Repository> getAllRepositoryByUserName();
    void createRepository(Repository repository);


}
