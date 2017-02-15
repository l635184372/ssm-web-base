package com.liang.ssm.entity.messagereq;

/**
 * 类名: ImageMessage </br>
 * 描述: 请求消息之图片消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016年12月22日15:05:57 </br>
 * 发布版本：V1.0  </br>
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;
    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
