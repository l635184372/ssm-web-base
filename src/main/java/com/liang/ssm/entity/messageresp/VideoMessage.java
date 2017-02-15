package com.liang.ssm.entity.messageresp;

/**
 * 类名: VideoMessage </br>
 * 描述: 视频消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
public class VideoMessage extends BaseMessage {
    // 视频
    private Video Video;

    public com.liang.ssm.entity.messageresp.Video getVideo() {
        return Video;
    }

    public void setVideo(com.liang.ssm.entity.messageresp.Video video) {
        Video = video;
    }
}
