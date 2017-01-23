package com.medal.weixin.sdk.message.response;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import lombok.Data;

/**
 * 回复文本消息
 *
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>12345678</CreateTime>
 * <MsgType><![CDATA[text]]></MsgType>
 * <Content><![CDATA[你好]]></Content>
 * </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
@Data
public class TextMessageResp extends BaseMessageResp {

    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    private String Content;
}
