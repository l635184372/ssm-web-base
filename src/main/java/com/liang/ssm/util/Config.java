package com.liang.ssm.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类名: Config </br>
 * 描述: 获取config.properties配置文件中的内容 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/28 </br>
 * 发布版本：V1.0  </br>
 */
@Component
public class Config {
    /**
     * 微信公众号APP_ID
     */
    @Value("#{settings['wx.appid']}")
    public String APP_ID;
    /**
     * 微信公众号SECRET
     */
    @Value("#{settings['wx.secret']}")
    public String SECRET;
}
