package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;
import lombok.Data;

/**
 * 图片消息
 *  <xml>
 *  <ToUserName><![CDATA[toUser]]></ToUserName>
 *  <FromUserName><![CDATA[fromUser]]></FromUserName>
 *  <CreateTime>1348831860</CreateTime>
 *  <MsgType><![CDATA[image]]></MsgType>
 *  <PicUrl><![CDATA[this is a url]]></PicUrl>
 *  <MediaId><![CDATA[media_id]]></MediaId>
 *  <MsgId>1234567890123456</MsgId>
 *  </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
@Data
public class ImageMessageReq extends BaseMessageReq {
    /**
     * 图片链接(开发者可以通过该链接从微信服务器上下载用户发送的图片)
     */
    private String PicUrl;
}
