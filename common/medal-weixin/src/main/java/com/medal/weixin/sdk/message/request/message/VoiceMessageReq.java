package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;

/**
 * 语音消息
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime>
 * <MsgType><![CDATA[voice]]></MsgType>
 * <MediaId><![CDATA[media_id]]></MediaId>
 * <Format><![CDATA[Format]]></Format>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
public class VoiceMessageReq extends BaseMessageReq {

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String MediaId;

    /**
     * 语音格式，如amr，speex等 使用UTF8编码
     */
    private String Format;
}
