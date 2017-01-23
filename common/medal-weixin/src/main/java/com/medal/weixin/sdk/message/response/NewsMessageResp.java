package com.medal.weixin.sdk.message.response;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import lombok.Data;

import java.util.List;

/**
 * 图文消息
 *
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>12345678</CreateTime>
 <MsgType><![CDATA[news]]></MsgType>
 <ArticleCount>2</ArticleCount>
 <Articles>
 <item>
 <Title><![CDATA[title1]]></Title>
 <Description><![CDATA[description1]]></Description>
 <PicUrl><![CDATA[picurl]]></PicUrl>
 <Url><![CDATA[url]]></Url>
 </item>
 <item>
 <Title><![CDATA[title]]></Title>
 <Description><![CDATA[description]]></Description>
 <PicUrl><![CDATA[picurl]]></PicUrl>
 <Url><![CDATA[url]]></Url>
 </item>
 </Articles>
 </xml>
 *
 * Created by xhuji on 2016/9/1.
 */
@Data
public class NewsMessageResp extends BaseMessageResp {

    /**
     * 图文消息个数，限制为10条以内
     */
    private int ArticleCount;

    /**
     *  多条图文消息信息，默认第一个item为大图
     */
    private List<Article> Articles;
}


