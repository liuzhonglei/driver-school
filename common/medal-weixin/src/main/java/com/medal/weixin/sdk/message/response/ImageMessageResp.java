package com.medal.weixin.sdk.message.response;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import lombok.Data;

/**
 * 回复图片消息
 *
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>12345678</CreateTime>
 <MsgType><![CDATA[image]]></MsgType>
 <Image>
 <MediaId><![CDATA[media_id]]></MediaId>
 </Image>
 </xml>

 * Created by xhuji on 2016/10/20.
 */
@Data
public class ImageMessageResp extends BaseMessageResp{
    /**
     * 图片
     */
    private Image image;
}
