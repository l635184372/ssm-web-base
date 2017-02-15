package com.liang.ssm.service.impl;

import com.liang.ssm.entity.AccessToken;
import com.liang.ssm.entity.ResponseMsg;
import com.liang.ssm.entity.WxUserInfo;
import com.liang.ssm.entity.messageresp.TextMessage;
import com.liang.ssm.entity.messageresp.VoiceMessage;
import com.liang.ssm.service.MessageService;
import com.liang.ssm.util.HttpClientUtil;
import com.liang.ssm.util.MessageUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Map;

/**
 * 类名: MessageServiceImpl </br>
 * 描述:  </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {

    Logger logger = Logger.getLogger(MessageServiceImpl.class);

    /**
     * 处理微信请求方法的具体实现
     * @param request
     * @return
     */
    public String processRequest(HttpServletRequest request) throws IOException, DocumentException {

        //将从微信接收的消息转化为标准的XML格式，同时使用map进行存储
        logger.info("开始解析接收到的用户信息......");
        Map<String,String> map = MessageUtil.parseXml(request);
        String respContent = "不知道什么鬼！";
        String msgType = map.get("MsgType");
        logger.info("判断用户信息类型："+msgType);
        if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){
            respContent = "你发的是文字消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)){
            respContent = "你发的是图片消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) {
            respContent = "你发的是语音消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)) {
            respContent = "你发的是视频消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msgType)) {
            respContent = "你发的是链接消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) {
            respContent = "你发的是地理位置消息！";
        }else if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
            String event = map.get("Event");
            if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(event)){
                respContent = "你好，欢迎关注！";
            }else if(MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(event)){
                respContent = "小贱君都是傻逼！";
            }else if(MessageUtil.EVENT_TYPE_VIEW.equals(event)){
                String action = map.get("EventKey");
                logger.info("action:"+action);
                HttpEntity entity = HttpClientUtil.httpGet(action);

                return "-1";
            }else if(MessageUtil.EVENT_TYPE_CLICK.equals(event)){
                if("05_SIGN".equals(map.get("EventKey"))){
                    respContent="<a href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx536c2fee47890812&redirect_uri=http://tis.waw.com.cn/ssm-web&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect'>授权登录</a>";
                }
            }
            else{
                respContent = "你发的是事件类型，暂时还不知道是什么鬼！";
            }
        }
        logger.info("设置回复信息！");
        //测试时暂时仅返回文本信息回复
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;
        TextMessage textMessage = new TextMessage();
        VoiceMessage voiceMessage = new VoiceMessage();
        //返回信息的目标用户为客户端接收到的用户的openid
        textMessage.setToUserName(map.get("FromUserName"));
        //返回信息的来源为微信公众号本体
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setCreateTime(returnTime);
        //默认设置返回信息的类型为文本回复，若需要回复的信息为其他类型，则需要根据相应的判断条件进行相应的更改设置
        textMessage.setMsgType("text");
        textMessage.setContent(respContent);
        logger.info(textMessage.getToUserName()+textMessage.getContent());
        String xmlStr = MessageUtil.messageObjectToXml(textMessage);
        logger.info(xmlStr);
        return xmlStr;
    }
}
