package com.medal.weixin.sdk.util;

import com.medal.weixin.sdk.message.response.Article;
import com.medal.weixin.sdk.message.response.Music;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by xhuji on 2016/10/21.
 */
public class CustomMessageUtil {
    /**
     * 组装文本客服消息
     *
     * @param openId 消息发送对象
     * @param content 文本消息内容
     * @return
     */
    public static String makeTextCustomMessage(String openId, String content) {
        // 对消息内容中的双引号进行转义
        content = content.replace("\"", "\\\"");
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
        return String.format(jsonMsg, openId, content);
    }

    /**
     * 组装图片客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @return
     */
    public static String makeImageCustomMessage(String openId, String mediaId) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}}";
        return String.format(jsonMsg, openId, mediaId);
    }

    /**
     * 组装语音客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @return
     */
    public static String makeVoiceCustomMessage(String openId, String mediaId) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}}";
        return String.format(jsonMsg, openId, mediaId);
    }

    /**
     * 组装视频客服消息
     *
     * @param openId 消息发送对象
     * @param mediaId 媒体文件id
     * @param thumbMediaId 视频消息缩略图的媒体id
     * @return
     */
    public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\"}}";
        return String.format(jsonMsg, openId, mediaId, thumbMediaId);
    }

    /**
     * 组装音乐客服消息
     *
     * @param openId 消息发送对象
     * @param music 音乐对象
     * @return
     */
    public static String makeMusicCustomMessage(String openId, Music music) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":%s}";
        jsonMsg = String.format(jsonMsg, openId, JSONObject.fromObject(music).toString());
        // 将jsonMsg中的thumbmediaid替换为thumb_media_id
        jsonMsg = jsonMsg.replace("thumbmediaid", "thumb_media_id");
        return jsonMsg;
    }

    /**
     * 组装图文客服消息
     *
     * @param openId 消息发送对象
     * @param articleList 图文消息列表
     * @return
     */
    public static String makeNewsCustomMessage(String openId, List<Article> articleList) {
        String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\":%s}}";
        jsonMsg = String.format(jsonMsg, openId, JSONArray.fromObject(articleList).toString().replaceAll("\"", "\\\""));
        // 将jsonMsg中的picUrl替换为picurl
        jsonMsg = jsonMsg.replace("picUrl", "picurl");
        return jsonMsg;
    }
}
