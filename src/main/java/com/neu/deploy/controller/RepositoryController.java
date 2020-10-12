package com.neu.deploy.controller;

import com.neu.deploy.domain.Repository;
import com.neu.deploy.domain.Token;
import com.neu.deploy.dto.request.RepositoryCreateRequest;
import com.neu.deploy.exception.general.PermissionDeniedException;
import com.neu.deploy.exception.general.RequestFailedException;
import com.neu.deploy.exception.general.ResourceExistedException;
import com.neu.deploy.services.RepositoryService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: treblez
 * @Date: 2020/10/11 17:13
 */
@RestController
@RequestMapping("/repository")
@Validated
public class RepositoryController {
    @Autowired
    RepositoryService repositoryService;

    @PostMapping("/{username}/create")
    public void createRepository(@PathVariable(value = "username")String userId,@RequestParam Token token,
                                 @RequestBody @Valid RepositoryCreateRequest repositoryCreateRequest) throws PermissionDeniedException, ResourceExistedException, RequestFailedException, JSONException {

        if(false) throw new PermissionDeniedException("没有权限") ;
        Repository repository = repositoryCreateRequest.getRepository();
//        Repository repository = repositoryCreateRequest
//        repositoryService
        repositoryService.create(userId,repository);




    }


}
