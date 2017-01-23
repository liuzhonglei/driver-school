package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;
import lombok.Data;

/**
 * 文本消息
 *  <xml>
 *  <ToUserName><![CDATA[toUser]]></ToUserName>
 *  <FromUserName><![CDATA[fromUser]]></FromUserName>
 *  <CreateTime>1348831860</CreateTime>
 *  <MsgType><![CDATA[text]]></MsgType>
 *  <Content><![CDATA[this is a test]]></Content>
 *  <MsgId>1234567890123456</MsgId>
 *  </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
@Data
public class TextMessageReq extends BaseMessageReq {
    /**
     * 消息内容
     */
    private String Content;
}
