package com.liang.ssm.entity.messageresp;

/**
 * 类名: VoiceMessage </br>
 * 描述: 语音消息 </br>
 * 开发人员： Liangqx </br>
 * 创建时间： 2016/12/23 </br>
 * 发布版本：V1.0  </br>
 */
public class VoiceMessage extends BaseMessage{
    // 语音
    private Voice Voice;

    public com.liang.ssm.entity.messageresp.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.liang.ssm.entity.messageresp.Voice voice) {
        Voice = voice;
    }
}
