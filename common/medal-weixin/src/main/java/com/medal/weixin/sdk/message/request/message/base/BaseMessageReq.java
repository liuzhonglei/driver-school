package com.medal.weixin.sdk.message.request.message.base;

import lombok.Data;

/**
 * 请求消息基类（普通用户 -> 公众帐号）
 *
 * 消息类型包括{{文本消息:text},{图片消息:image},{语音消息:voice},{视频消息:video},{小视频消息:shortvideo},{地理位置消息:location},{链接消息:}}共7种
 * Created by xhuji on 2016/9/1.
 */
@Data
public class BaseMessageReq {
    /**
     * 开发者微信号(公众帐号的原始ID)
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     *  消息创建时间 （整型）(从1970年1月1日0时0分0秒至消息创建所间隔的秒数)
     */
    private long CreateTime;
    /**
     * 消息类型（text/image/location/link/voice/shortvideo）
     */
    private String MsgType;
    /**
     * 消息id，64位整型
     */
    private long MsgId;
}
