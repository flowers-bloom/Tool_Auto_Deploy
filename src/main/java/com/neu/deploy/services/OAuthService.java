package com.neu.deploy.services;

import com.neu.deploy.domain.HTTPResponse;
import com.neu.deploy.exception.general.RequestFailedException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: treblez
 * @Date: 2020/10/12 14:57
 * @Description:对OAuth进行访问
 */
@Service
public class OAuthService {
    @Autowired
    public static HTTPResponse httpResponse;
    @Value("${repository.getPath}")
    public static String getAddress;


    /**
     * 得到仓库Clone-url的方法
     *
     * @return String 返回String的Url
     */
    public static String getCloneUrl(String username,String repositoryName) throws JSONException, RequestFailedException {
        String urlNameString;
        urlNameString = getAddress+username+"/"+repositoryName;
        String result = new String();
        httpResponse = HTTPService.getRequest(urlNameString,null);
        result = httpResponse.getBody().getString("clone_url");
        return result;
    }
    /**
     * 通过用户名模糊搜索仓库
     * 搜索的github仓库信息来源于当前用户对应的github账号具有权限的github仓库
     *
     * @param username
     *            用户名
     * @return List<String> 仓库名列表
     */
    public List<String> getFuzzyGitRepositoryName(String username){
        List<String>  repositoryName = new ArrayList<>();


        return repositoryName;
    }
}
