package com.liang.ssm.service.impl;

import com.liang.ssm.entity.AccessToken;
import com.liang.ssm.entity.ResponseMsg;
import com.liang.ssm.service.MenuService;
import com.liang.ssm.util.AccessTokenCache;
import com.liang.ssm.util.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/16.
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

    private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

    private static Map<String,String> map = new HashMap<String,String>();

    public Map<String,String> menuCreate(String appId) throws Exception {
        AccessToken accessToken = AccessTokenCache.get();
        if(accessToken == null || accessToken.getErrcode() == 40013) {
            map.put("msg", "获取access_token失败！");
            map.put("retCode", "false");
            return map;
        }else {
            String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken.getAccess_token();
            String menu = "{\"button\":[{\"type\":\"view\",\"name\":\"授权登录\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=APP_ID&redirect_uri=http://tis.waw.com.cn/ssm-web/wx/getWxUserInfo&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect\"},{\"type\":\"view\",\"name\":\"商铺首页\",\"url\":\"http://tis.waw.com.cn/ssm-web/wx/index\"},{\"name\":\"日常工作\",\"sub_button\":[{\"type\":\"click\",\"name\":\"待办工单\",\"key\":\"01_WAITING\"},{\"type\":\"click\",\"name\":\"已办工单\",\"key\":\"02_FINISH\"},{\"type\":\"click\",\"name\":\"我的工单\",\"key\":\"03_MYJOB\"},{\"type\":\"click\",\"name\":\"公告消息箱\",\"key\":\"04_MESSAGEBOX\"},{\"type\":\"click\",\"name\":\"签到\",\"key\":\"05_SIGN\"}]}]}";
            menu = menu.replace("APP_ID",appId);
            HttpEntity entity = HttpClientUtil.httpPost(action,menu);
            ResponseMsg responseMsg = new ObjectMapper().readValue(EntityUtils.toString(entity), ResponseMsg.class);
            if(responseMsg != null && responseMsg.getErrcode() == 0){
                map.put("retCode","success");
            }else{
                map.put("msg","调用创建接口失败！");
                map.put("retCode","false");
            }
            return map;
        }
    }

    /**
     * 删除菜单，get方式
     * @return
     * @throws Exception
     */
    public Map<String,String> menuDelete() throws Exception {
        AccessToken accessToken = AccessTokenCache.get();
        if(accessToken == null || accessToken.getErrcode() == 40013){
            map.put("msg","获取access_token失败！");
            map.put("retCode","false");
            return map;
        }else{
            String action = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="+accessToken.getAccess_token();
            HttpEntity entity = HttpClientUtil.httpGet(action);
            ResponseMsg responseMsg = new ObjectMapper().readValue(EntityUtils.toString(entity), ResponseMsg.class);
            if(responseMsg != null && responseMsg.getErrcode() == 0){
                map.put("retCode","success");
            }else{
                map.put("msg","调用删除接口失败！");
                map.put("retCode","false");
            }
            return map;
        }
    }

    public Map<String,String> menuGet() {
        return null;
    }

//    private Map<String,String> validateAccessToken() throws Exception {
//        map.clear();
//        AccessToken accessToken = AccessTokenCache.get();
//        if(accessToken == null || accessToken.getErrcode() == 40013){
//            map.put("msg","获取access_token失败！");
//            map.put("retCode","false");
//        }
//        return map;
//    }
}
