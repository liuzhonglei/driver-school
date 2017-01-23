package com.medal.weixin.sdk.message.event;

import com.medal.weixin.sdk.message.event.base.BaseEvent;
import lombok.Data;

/**
 * 上报地理位置事件
 * 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。上报地理位置时，微信会将上报地理位置事件推送到开发者填写的URL。
 *
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>123456789</CreateTime>
 <MsgType><![CDATA[event]]></MsgType>
 <Event><![CDATA[LOCATION]]></Event>
 <Latitude>23.137466</Latitude>
 <Longitude>113.352425</Longitude>
 <Precision>119.385040</Precision>
 </xml>

 * Created by xhuji on 2016/9/1.
 */
@Data
public class LocationEvent extends BaseEvent {
	/**
	 * 地理位置纬度
	 */
	private String Latitude;
	/**
	 * 地理位置经度
	 */
	private String Longitude;
	/**
	 * 地理位置精度
	 */
	private String Precision;

}
