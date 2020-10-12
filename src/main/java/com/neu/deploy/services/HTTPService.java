package com.neu.deploy.services;

import com.neu.deploy.domain.HTTPResponse;
import com.neu.deploy.exception.general.RequestFailedException;
import org.graalvm.compiler.replacements.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Author: treblez
 * @Date: 2020/10/12 17:55
 * @Descirption 发送get和post请求
 */
public class HTTPService {
    @Autowired
    static HTTPResponse httpResponse;
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param urlNameString
     *            发送请求的URL
     * @param headers
     *            请求参数
     * @return HTTPResponse 所代表远程资源的响应结果
     */
    public static HTTPResponse getRequest(String urlNameString, Map<String,String> headers) throws RequestFailedException {
        InputStreamReader in = null;
        try {
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            for (Map.Entry<String,String> entry:headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(),entry.getValue());
            }
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new InputStreamReader(connection.getInputStream());
//            JsonReader jsonReader = new JsonReader(in);
            JSONObject jsonObject=new JSONObject(in.toString());
            httpResponse.setHeaders(map);
            httpResponse.setBody(jsonObject);
        } catch (Exception e) {
            Log.print("Get请求"+urlNameString+"出现异常！"+ e);
            e.printStackTrace();
            throw new RequestFailedException("网络请求异常");
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return httpResponse;
    }

}
