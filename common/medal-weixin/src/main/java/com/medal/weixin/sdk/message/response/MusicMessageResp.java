package com.medal.weixin.sdk.message.response;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;

/**
 * 回复音乐消息
 *
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>12345678</CreateTime>
 <MsgType><![CDATA[music]]></MsgType>
 <Music>
 <Title><![CDATA[TITLE]]></Title>
 <Description><![CDATA[DESCRIPTION]]></Description>
 <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
 <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
 <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
 </Music>
 </xml>

 * Created by xhuji on 2016/9/1.
 */
public class MusicMessageResp extends BaseMessageResp {
    /**
     * 音乐
     */
    private Music Music;
}