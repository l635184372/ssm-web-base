package com.liang.ssm.service;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
public interface MenuService {
    Map<String,String> menuCreate(String appId) throws Exception;
    Map<String,String> menuDelete() throws Exception;
    Map<String,String> menuGet();
}
