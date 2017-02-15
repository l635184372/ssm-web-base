package com.liang.ssm.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 会话客户端类，包含两种会话方式，GET方式和POST方式
 * Created by Liangqx on 2016/12/16.
 */
public class HttpClientUtil {

    private static Logger logger = Logger.getLogger(HttpClientUtil.class);

    /**
     * 通过Get方式与微信服务器进行会话
     * @param action ： 会话地址
     * @return entity ：微信服务器返回信息对象
     * @throws IOException
     */
    public static HttpEntity httpGet(String action){
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(action);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl.toString());
        CloseableHttpResponse res = null;
        HttpEntity entity = null;
        try{
            res = client.execute(httpGet);
            entity = res.getEntity();//返回结果
        }catch (IOException e){
            logger .info("微信服务器调用接口访问失败！"+e.getMessage());
        }finally {
            try {
                res.close();
            } catch (IOException ex) {
                logger.info("CloseableHttpResponse 通道关闭失败！"+ex.getMessage());
            }
        }
        return entity;
    }

    /**
     * 通过POST方式与微信服务器进行会话
     * @param action ：会话地址
     * @param params ：会话中传递的参数（当前为仅一个参数）
     * @return entity ：微信服务器返回信息对象
     * @throws IOException
     */
    public static HttpEntity httpPost(String action,String params)  {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(action);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl.toString());
        httpPost.setEntity(new StringEntity(params,"utf-8"));//设置参数
        CloseableHttpResponse res = null;
        HttpEntity entity = null;
        try {
            res = client.execute(httpPost);
            entity = res.getEntity(); //返回结果
        } catch (IOException e) {
            logger.info("微信服务器调用接口访问失败！"+e.getMessage());
        }finally {
            try {
                res.close();
            } catch (IOException ex) {
                logger.info("CloseableHttpResponse 通道关闭失败！"+ex.getMessage());
            }
        }
        return entity;
    }
}
