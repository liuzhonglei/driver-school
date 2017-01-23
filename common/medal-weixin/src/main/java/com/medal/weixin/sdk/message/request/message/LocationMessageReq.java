package com.medal.weixin.sdk.message.request.message;

import com.medal.weixin.sdk.message.request.message.base.BaseMessageReq;
import lombok.Data;

/**
 * 地理位置消息
 *
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[fromUser]]></FromUserName>
 * <CreateTime>1351776360</CreateTime>
 * <MsgType><![CDATA[location]]></MsgType>
 * <Location_X>23.134521</Location_X>
 * <Location_Y>113.358803</Location_Y>
 * <Scale>20</Scale>
 * <Label><![CDATA[位置信息]]></Label>
 * <MsgId>1234567890123456</MsgId>
 * </xml>
 * Created by xhuji on 2016/9/1.
 */
@Data
public class LocationMessageReq extends BaseMessageReq {

    /**
     * 地理位置维度
     */
    private String LocationX;

    /**
     * 地理位置经度
     */
    private String LocationY;

    /**
     * 地图缩放大小
     */
    private String Scale;

    /**
     * 地理位置信息
     */
    private String Label;
}
