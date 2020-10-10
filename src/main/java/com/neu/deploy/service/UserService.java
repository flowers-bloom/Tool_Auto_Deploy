package com.neu.deploy.service;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lzs
 * @date 2020/10/10 19:17
 * @description
 */
@Service
public class UserService {
    @Autowired
    CloseableHttpClient httpsClient;

    @Value("${oauth.id}")
    String oauthId;
    @Value("${oauth.secret}")
    String oauthSecret;

    public void getAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token";
        List<BasicNameValuePair> pairList = new ArrayList<>();
        pairList.add(new BasicNameValuePair("code", code));
        pairList.add(new BasicNameValuePair("client_id", oauthId));
        pairList.add(new BasicNameValuePair("client_secret", oauthSecret));

        HttpPost httpPost = new HttpPost(url);
        System.out.println(oauthId + " " + oauthSecret);
        try{
            UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(pairList, "utf-8");
            httpPost.setEntity(encodedFormEntity);

            CloseableHttpResponse response = httpsClient.execute(httpPost);
            String json = EntityUtils.toString(response.getEntity());
            System.out.println(json);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}