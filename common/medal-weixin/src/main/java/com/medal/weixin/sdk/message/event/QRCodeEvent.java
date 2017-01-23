package com.medal.weixin.sdk.message.event;

import com.medal.weixin.sdk.message.event.base.BaseEvent;
import lombok.Data;

/**
 * 扫描带参数二维码事件
 * 用户扫描带场景值二维码时，可能推送以下两种事件：
 * 1. 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * <xml><ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[FromUser]]></FromUserName>
 <CreateTime>123456789</CreateTime>
 <MsgType><![CDATA[event]]></MsgType>
 <Event><![CDATA[subscribe]]></Event>
 <EventKey><![CDATA[qrscene_123123]]></EventKey>
 <Ticket><![CDATA[TICKET]]></Ticket>
 </xml>
 * 2. 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[FromUser]]></FromUserName>
 <CreateTime>123456789</CreateTime>
 <MsgType><![CDATA[event]]></MsgType>
 <Event><![CDATA[SCAN]]></Event>
 <EventKey><![CDATA[SCENE_VALUE]]></EventKey>
 <Ticket><![CDATA[TICKET]]></Ticket>
 </xml>
 * Created by xhuji on 2016/9/1.
 */
@Data
public class QRCodeEvent extends BaseEvent {
	/**
	 * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	 */
	private String EventKey;
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	private String Ticket;

}
