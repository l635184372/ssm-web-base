package com.liang.ssm.entity;

/**
 * Created by liangqx on 2016/12/15.
 */
public class AccessToken extends ResponseMsg{
    /**
    * 错误时返回前两个参数，{"errcode":40013,"errmsg":"invalid appid"}
    * 正确时返回后面两个参数，{"access_token":"ACCESS_TOKEN","expires_in":7200}
    *
    */
    //获取到的凭证
    private String access_token;
    //凭证有效时间，单位：秒
    private int expires_in;
    //用户刷新access_token  针对网页access_token
    private String refresh_token;
    //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID 针对网页
    private String openid;
    //用户授权的作用域，使用逗号（,）分隔 针对网页
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
