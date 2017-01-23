package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;

/**
 * 链接消息
 *
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1351776360</CreateTime>
 * <MsgType><![CDATA[link]]></MsgType>
 * <Title><![CDATA[公众平台官网链接]]></Title>
 * <Description><![CDATA[公众平台官网链接]]></Description>
 * <Url><![CDATA[url]]></Url>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
public class LinkMessageReq extends BaseMessageReq {

    /**
     * 消息标题
     */
    private String Title;

    /**
     * 消息描述
     */
    private String Description;

    /**
     * 消息链接
     */
    private String Url;
}
