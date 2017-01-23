package com.medal.weixin.sdk.message.event;

import com.medal.weixin.sdk.message.event.base.BaseEvent;
import lombok.Data;

/**
 * 关注/取消关注事件
 * 用户在关注与取消关注公众号时，微信会把这个事件推送到开发者填写的URL。方便开发者给用户下发欢迎消息或者做帐号的解绑。
 * <xml>
 * <<ToUserName><![CDATA[toUser]]></ToUserName>
 * <<FromUserName><![CDATA[FromUser]]></FromUserName>
 * <<CreateTime>123456789</CreateTime>
 * <<MsgType><![CDATA[event]]></MsgType>
 * <<Event><![CDATA[subscribe]]></Event>
 * <</xml>
 * Created by xhuji on 2016/9/1.
 */
@Data
public class SubscribeEvent extends BaseEvent {

}
