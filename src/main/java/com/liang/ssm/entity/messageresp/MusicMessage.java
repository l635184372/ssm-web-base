package com.liang.ssm.entity.messageresp;

/**
 * 类名: MusicMessage </br>
 * 描述: 音乐消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public com.liang.ssm.entity.messageresp.Music getMusic() {
        return Music;
    }

    public void setMusic(com.liang.ssm.entity.messageresp.Music music) {
        Music = music;
    }
}
