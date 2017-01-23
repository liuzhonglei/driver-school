package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * Created by xhuji on 2016/10/21.
 */
@Slf4j
public class CustomClient {
    /**
     * 发送客服消息
     *  在用户主动给公众帐号发送消息之后的48个小时以内，开发者可以调用客服接口给用户发送消息，并且没有次数限制
     * 1. 发送文本消息
     * 2. 发送图片消息
     * 3. 发送语音消息
     * 4. 发送视频消息
     * 5. 发送音乐消息
     * 6. 发送图文消息（点击跳转到外链） 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应。
     * 7. 发送卡券
     * @param accessToken 接口访问凭证
     * @param jsonMsg json格式的客服消息（包括touser、msgtype和消息内容）
     * @return true | false
     */
    public static boolean sendCustomMessage(String accessToken, String jsonMsg) {
        log.debug("消息内容：{}", jsonMsg);
        boolean result = false;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 发送客服消息
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", jsonMsg);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
                log.info("客服消息发送成功 errcode:{} errmsg:{}", errorCode, errorMsg);
            } else {
                log.error("客服消息发送失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}
