package com.liang.ssm.entity.messagereq;

import java.io.Serializable;

/**
 * 类名: TextMessage </br>
 * 描述: 请求消息之文本消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间：  2016年12月19日09:18:38 </br>
 * 发布版本：V1.0  </br>
 */
public class TextMessage extends BaseMessage implements Serializable{
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
