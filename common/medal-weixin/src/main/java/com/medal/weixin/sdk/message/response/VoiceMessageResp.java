package com.medal.weixin.sdk.message.response;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import lombok.Data;

/**
 * 回复语音消息
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>12345678</CreateTime>
 <MsgType><![CDATA[voice]]></MsgType>
 <Voice>
 <MediaId><![CDATA[media_id]]></MediaId>
 </Voice>
 </xml>
 * Created by xhuji on 2016/10/20.
 */
@Data
public class VoiceMessageResp extends BaseMessageResp{
    /**
     * 语音
     */
    private Voice voice;
}
