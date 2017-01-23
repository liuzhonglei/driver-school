package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;
import lombok.Data;

/**
 * 视频消息（包括小视频）
 *
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime>
 * <MsgType><![CDATA[video]]></MsgType>
 * <MediaId><![CDATA[media_id]]></MediaId>
 * <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 *
 * 小视频
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1357290913</CreateTime>
 * <MsgType><![CDATA[shortvideo]]></MsgType>
 * <MediaId><![CDATA[media_id]]></MediaId>
 * <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 * Created by xhuji on 2016/10/19.
 */
@Data
public class MediaMessageReq extends BaseMessageReq{

    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String MediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String ThumbMediaId;
}
