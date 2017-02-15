package com.liang.ssm.service;

import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 类名: MessageService </br>
 * 描述: 消息处理服务接口 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
public interface MessageService {
    /**
     * 处理微信请求方法
     * @param request
     * @return
     */
    String processRequest(HttpServletRequest request) throws IOException, DocumentException;
}
