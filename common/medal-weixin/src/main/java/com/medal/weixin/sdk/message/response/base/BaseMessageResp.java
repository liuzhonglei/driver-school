package com.medal.weixin.sdk.message.response.base;

import lombok.Data;

/**
 * 消息基类（公众帐号 -> 普通用户）
 *
 * 消息类型包括{{文本消息:text},{图片消息:image},{语音消息:voice},{视频消息:video},{小视频消息:shortvideo},{音乐:location},{图文:}}共7种
 *
 * Created by xhuji on 2016/9/1.
 */
@Data
public class BaseMessageResp {

    /**
     * 接收方帐号（收到的OpenID）
     */
    private String ToUserName;

    /**
     * 开发者微信号
     */
    private String FromUserName;

    /**
     * 消息创建时间
     */
    private long CreateTime;

    /**
     * 消息类型（text/music/news）
     */
    private String MsgType;

    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
    private int FuncFlag;
}
