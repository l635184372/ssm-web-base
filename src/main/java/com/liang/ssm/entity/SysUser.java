package com.liang.ssm.entity;

/**
 * Created by Administrator on 2016/12/14.
 */
public class SysUser {

    private String id;

    private String logInName;

    private String passWord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogInName() {
        return logInName;
    }

    public void setLogInName(String logInName) {
        this.logInName = logInName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
