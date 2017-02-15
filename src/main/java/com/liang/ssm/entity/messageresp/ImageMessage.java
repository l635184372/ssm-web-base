package com.liang.ssm.entity.messageresp;

/**
 * 类名: ImageMessage </br>
 * 描述: 图片消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
public class ImageMessage extends BaseMessage{
    private Image Image;

    public com.liang.ssm.entity.messageresp.Image getImage() {
        return Image;
    }

    public void setImage(com.liang.ssm.entity.messageresp.Image image) {
        Image = image;
    }
}
