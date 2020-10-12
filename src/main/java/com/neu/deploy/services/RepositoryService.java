package com.neu.deploy.services;

import com.neu.deploy.common.Shell;
import com.neu.deploy.domain.Repository;
import com.neu.deploy.exception.general.RequestFailedException;
import com.neu.deploy.exception.general.ResourceExistedException;
import com.neu.deploy.mapper.RepositoryMapper;
import com.sun.tools.sjavac.Log;
import lombok.Getter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * @Author: treblez
 * @Date: 2020/10/11 17:26
 */
@Service
@ConfigurationProperties(prefix = "library")
public class RepositoryService {

    @Getter
    @NotNull
    private String defaultPath;
    @Autowired
    private OAuthService oAuthService;
    @Resource
    private RepositoryMapper repositoryMapper;



    public void create(String userName,Repository repository) throws ResourceExistedException, RequestFailedException, JSONException {
        Repository r  =repositoryMapper.getRepositoryByLocalName(repository.getLocalRepositoryName());

        if(r!=null){
            throw new ResourceExistedException("仓库已经存在！");
        }
        r.setRepositoryVersion("1.0");
        r.setRepositoryPath(defaultPath+repository.getLocalRepositoryName());
        Calendar Cld = Calendar.getInstance();
        int YY = Cld.get(Calendar.YEAR) ;
        int MM = Cld.get(Calendar.MONTH)+1;
        int DD = Cld.get(Calendar.DATE);
        int HH = Cld.get(Calendar.HOUR_OF_DAY);
        int mm = Cld.get(Calendar.MINUTE);
        int SS = Cld.get(Calendar.SECOND);
        int MI = Cld.get(Calendar.MILLISECOND);
        String id = new String();
        id=  id+YY+MM+DD+HH+mm+SS+MI;
        Log.info("The generated repository Id is:"+id);

        r.setRepositoryId(Long.parseLong(id));
//        String gitAddress = oAuthService.getGitAddress(repository.get)
        Shell.cloneRepository(OAuthService.getCloneUrl(userName,r.getGithubRepositoryName()));
        repositoryMapper.createRepository(r);

    }




    public List<String> fuzzySearch(String repositoryName){
        List<String> repositoryList = new ArrayList<>();


        return repositoryList;

    }

}
