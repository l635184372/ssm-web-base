package com.liang.ssm.entity;

/**
 * Created by Administrator on 2016/12/16.
 */
public class ResponseMsg {
    //错误代码
    private int errcode;
    //错误信息
    private String errmsg;

    private String code;

    private String state;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
