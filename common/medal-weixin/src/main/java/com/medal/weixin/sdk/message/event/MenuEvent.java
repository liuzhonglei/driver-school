package com.medal.weixin.sdk.message.event;

import com.medal.weixin.sdk.message.event.base.BaseEvent;
import lombok.Data;

/**
 * 自定义菜单事件
 * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。
 *
 * 1. 点击菜单拉取消息时的事件推送
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[CLICK]]></Event>
 * <EventKey><![CDATA[EVENTKEY]]></EventKey>
 * </xml>
 * 2. 点击菜单跳转链接时的事件推送
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[VIEW]]></Event>
 * <EventKey><![CDATA[www.qq.com]]></EventKey>
 * </xml>
 * Created by xhuji on 2016/9/1.
 */
@Data
public class MenuEvent extends BaseEvent {
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String EventKey;
}
