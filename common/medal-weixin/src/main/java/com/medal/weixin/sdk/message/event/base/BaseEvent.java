package com.medal.weixin.sdk.message.event.base;

import lombok.Data;

/**
 * 事件基类
 * 事件类型包括{{关注/取消关注事件:text},{扫描带参数二维码事件:image},{上报地理位置事件:voice},{自定义菜单事件:video},{点击菜单拉取消息时的事件推送:shortvideo},{点击菜单跳转链接时的事件推送:location},{图文:}}共7种
 * 参考:https://mp.weixin.qq.com/wiki/7/9f89d962eba4c5924ed95b513ba69d9b.html
 * Created by xhuji on 2016/10/19.
 */
@Data
public class BaseEvent {

    /**
     * 开发者微信号
     */
    private String ToUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private String CreateTime;

    /**
     * 消息类型，event
     */
    private String MsgType;

    /**
     * 事件类型，subscribe(订阅)、unsubscribe(取消订阅)
     */
    private String Event;
}
