package com.liang.ssm.controller;

import com.liang.ssm.entity.AccessToken;
import com.liang.ssm.entity.WxUserInfo;
import com.liang.ssm.service.MenuService;
import com.liang.ssm.service.MessageService;
import com.liang.ssm.util.Config;
import com.liang.ssm.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@Controller
@RequestMapping(value = "/wx")
public class WXController {

    private Logger logger = Logger.getLogger(WXController.class);

    @Resource
    private MenuService menuService;

    @Resource
    private MessageService messageService;

    @Autowired
    private Config config;

    @RequestMapping(value = "/validateToken")
    public void sysUserList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if(isGet){//微信验证
            //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
            String signature = request.getParameter("signature");
            //时间戳
            String timestamp = request.getParameter("timestamp");
            //随机数
            String nonce = request.getParameter("nonce");
            //随机字符串
            String echostr = request.getParameter("echostr");
            response.getWriter().write(echostr);
        }else{//消息响应

            // 调用业务类接收消息、处理消息
            logger.info("开始请求信息处理......");
            String respMessage ="";
            try{
                respMessage = messageService.processRequest(request);
            }catch (Exception ex){
                logger.info(ex.getMessage());
            }
            // 响应消息
            if("-1".equals(respMessage)){

            }else{
                logger.info("开始返回响应信息......");
                PrintWriter out = response.getWriter();
                out.print(respMessage);
                out.close();
            }

        }
    }

    @RequestMapping(value = "menuCreate")
    public void menuCreate() throws Exception {
        logger.info("开始执行创建系统当前菜单操作......");
        Map<String,String> map = menuService.menuCreate(config.APP_ID);
        if(map.get("retCode").equals("success")){
            logger.info("当前系统菜单创建成功！");
        }else {
            logger.info("当前系统菜单创建失败！原因："+map.get("msg"));
        }
    }

    @RequestMapping(value = "menuDelete")
    public void menuDelete() {
        logger.info("开始执行删除系统当前菜单操作......");
        Map<String,String> map = new HashMap<String, String>();
        try {
            map = menuService.menuDelete();
            if(map.get("retCode").equals("success")){
                logger.info("当前系统菜单删除成功！");
            }else {
                logger.info("当前系统菜单删除失败！原因："+map.get("msg"));
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }

    @RequestMapping(value = "getWxUserInfo")
    public String getWxUserInfo(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        String code = request.getParameter("code");
        logger.info("code:"+code);
        String getTokenStr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        getTokenStr = getTokenStr.replace("APPID",config.APP_ID);
        getTokenStr = getTokenStr.replace("SECRET",config.SECRET);
        getTokenStr = getTokenStr.replace("CODE",code);
        logger.info(getTokenStr);
        HttpEntity entity = HttpClientUtil.httpGet(getTokenStr);
        logger.info(entity);
        AccessToken userAccessToken = new ObjectMapper().readValue(EntityUtils.toString(entity), AccessToken.class);
        logger.info("userAccessToken:"+userAccessToken.getAccess_token()+",openid:"+userAccessToken.getOpenid());
        String getUserInfoStr = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        getUserInfoStr = getUserInfoStr.replace("ACCESS_TOKEN",userAccessToken.getAccess_token());
        getUserInfoStr =  getUserInfoStr.replace("OPENID",userAccessToken.getOpenid());
        entity = HttpClientUtil.httpGet(getUserInfoStr);
        WxUserInfo wxUserInfo = new ObjectMapper().readValue(EntityUtils.toString(entity, HTTP.UTF_8), WxUserInfo.class);
        logger.info("openid:"+wxUserInfo.getOpenid()+",nickname:"+wxUserInfo.getNickname()+",sex:"+wxUserInfo.getSex());
        model.addAttribute("wxUserInfo",wxUserInfo);
        return "wxUserInfo";
    }

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request,HttpServletResponse response,Model model){

        return "index";
    }

    @RequestMapping(value = "test")
    public void test(HttpServletRequest request,HttpServletResponse response,Model model){
        logger.info("APP_ID:"+config.APP_ID+",SECERT:"+config.SECRET);
    }
}
