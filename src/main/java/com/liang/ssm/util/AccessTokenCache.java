package com.liang.ssm.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.liang.ssm.entity.AccessToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 使用缓存机制设置 accessToken 的失效，同时在失效后获取accessToken
 * 业务中获取 accessToken 需使用 AccessTokenCache.get() 方法来实现 ；因本系统暂未实现缓存更新机制，禁止使用 直结方式获取 accessToken 。
 * Created by Liangqx on 2016/12/15.
 */
@Component("accessTokenCache")
public class AccessTokenCache {

    private static Logger logger = Logger.getLogger(AccessTokenCache.class);

    private  static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=";
    //五征测试账号
    private  static final String APP_ID  = "wx121fa5b05a57e1ba";
    private  static final String SECRET  = "a0fc99f7ef5ffb2e7c13672d691911df";
    //开发人员测试账号
//    private  static final String APP_ID  = "wx536c2fee47890812";
//    private  static final String SECRET  = "ea2ea76667a7402cb7995f33ef2e9362";

    private static LoadingCache<String, AccessToken> cache;

    /**
     * 通过程序进行获取access_token并将其存入到缓存当中，access_token的过期时间为7200s = 2*60*60s
     * @throws Exception
     */
    public static void afterPropertiesSet() throws Exception {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(5) //同时写缓存的线程数
                .expireAfterWrite(2*60*60, TimeUnit.SECONDS) //写缓存后过期时间
                .initialCapacity(1) //缓存容器的初始容量
                .maximumSize(1) //缓存容器的最大容量，超出后按LRU淘汰
                .build(
                        new CacheLoader<String, AccessToken>() {
                            @Override
                            public AccessToken load(String key) throws Exception {
                                //获取access_token方法
                                logger.info("成功获取access_token！");
                                return getAccess_token();
                            }
                        }
                );
    }

    public static LoadingCache<String, AccessToken> getCache() {
        return cache;
    }

    public static void put(AccessToken value) {
        getCache().put("access_token", value);
    }

    /**
     * 当前方法仅针对存储的access_token进行取值
     * @return accessToken对象
     * @throws Exception
     */
    public static AccessToken get() throws Exception{
        return getCache().get("access_token");
    }

    /**
     * 通过微信接口获取access_token信息
     * @return accessToken
     * @throws IOException
     */
    private static AccessToken getAccess_token() throws IOException {
        StringBuilder requestUrl = new StringBuilder();
        requestUrl.append(GET_TOKEN_URL).append(APP_ID).append("&secret=").append(SECRET);//拼接地址
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl.toString());
        CloseableHttpResponse res = client.execute(httpGet);
        try{
            System.out.println(res.getStatusLine());
            HttpEntity entity = res.getEntity();//返回结果
            AccessToken accessToken = new ObjectMapper().readValue(EntityUtils.toString(entity), AccessToken.class);
            logger.info("access_token:"+accessToken.getAccess_token()+" ,expires_in:"+accessToken.getExpires_in()+" ,errmsg:" +accessToken.getErrmsg() +" ,errcode"+accessToken.getErrcode());
            return accessToken;
        } finally {
            res.close();
        }
    }
}
