package com.neu.deploy.common;

import com.neu.deploy.exception.general.ResourceExistedException;
import org.graalvm.compiler.replacements.Log;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: treblez
 * @Date: 2020/10/12 15:26
 * @Description shell操作
 */
public class Shell {

    @Value("${repository.getPath}")
    public static String shellPath;
    /**
     * clone仓库到shellPath
     * @param cloneUrl
     *            仓库Url
     *            例如：https://github.com/octocat/Hello-World.git
     */
    public static void cloneRepository(String cloneUrl){
        try{
            String bashCommand = "sh "+shellPath+ cloneUrl;
            Log.print("正在执行"+bashCommand);
            Runtime runtime = Runtime.getRuntime();
            Process pro = runtime.exec(bashCommand);
            int status = pro.waitFor();
            if (status != 0)
            {
                Log.print("Failed to call shell's command ");
                throw new ResourceExistedException("仓库已经存在！");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            StringBuffer strbr = new StringBuffer();
            String line;
            while ((line = br.readLine())!= null)
            {
                strbr.append(line).append("\n");
            }
            String result = strbr.toString();
            Log.print(result);

        }
        catch (IOException ec)
        {
            ec.printStackTrace();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        } catch (ResourceExistedException e) {
            e.printStackTrace();
        }

    }

}
