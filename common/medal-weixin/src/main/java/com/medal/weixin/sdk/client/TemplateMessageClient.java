package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * 模板消息接口 工具类
 *
 * 模板消息仅用于公众号向用户发送重要的服务通知，只能用于符合其要求的服务场景中，如信用卡刷卡通知，商品购买成功通知等。不支持广告等营销类消息以及其它所有可能对用户造成骚扰的消息。
 *
 * 使用规则:
 * 1、所有服务号都可以在功能->添加功能插件处看到申请模板消息功能的入口，但只有认证后的服务号才可以申请模板消息的使用权限并获得该权限；
 2、需要选择公众账号服务所处的2个行业，每月可更改1次所选行业；
 3、在所选择行业的模板库中选用已有的模板进行调用；
 4、每个账号可以同时使用25个模板。
 5、当前每个账号的模板消息的日调用上限为10万次，单个模板没有特殊限制。【2014年11月18日将接口调用频率从默认的日1万次提升为日10万次，可在MP登录后的开发者中心查看】。当账号粉丝数超过10W/100W/1000W时，模板消息的日调用上限会相应提升，以公众号MP后台开发者中心页面中标明的数字为准。
 *
 * 接口文档：
 * 1、模板消息调用时主要需要模板ID和模板中各参数的赋值内容；
 2、模板中参数内容必须以".DATA"结尾，否则视为保留字；
 3、模板保留符号"{{ }}"。
 *
 * Created by xhuji on 2016/10/31.
 */
@Slf4j
public class TemplateMessageClient {

    /**
     * 发送模板消息
     * @param accessToken 接口访问凭证
     * @param jsonMsg json格式的模板消息（包括touser、template_id、url和消息内容）
     * @return
     */
    public static boolean sendTemplateMessage(String accessToken, String jsonMsg){
        log.debug("模板消息内容：{}", jsonMsg);
        boolean result = false;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 发送客服消息
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", jsonMsg);
        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
                log.info("模板消息发送成功 errcode:{} errmsg:{}", errorCode, errorMsg);
            } else {
                log.error("模板消息发送失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}
