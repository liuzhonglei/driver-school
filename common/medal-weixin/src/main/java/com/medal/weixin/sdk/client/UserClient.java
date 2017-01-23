package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.pojo.WeixinUserInfo;
import com.medal.weixin.sdk.pojo.WeixinUserList;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * 用户信息
 * Created by xhuji on 2016/11/6.
 */
@Slf4j
public class UserClient {
    /**
     * 获取用户信息
     *
     * @param accessToken 接口访问凭证
     * @param openId 用户标识
     * @return WeixinUserInfo
     */
    public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
        WeixinUserInfo weixinUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 获取用户信息
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                weixinUserInfo = new WeixinUserInfo();
                // 用户的标识
                weixinUserInfo.setOpenId(jsonObject.getString("openid"));
                // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
                weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
                // 用户关注时间
                weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
                // 昵称
                weixinUserInfo.setNickname(jsonObject.getString("nickname"));
                // 用户的性别（1是男性，2是女性，0是未知）
                weixinUserInfo.setSex(jsonObject.getInt("sex"));
                // 用户所在国家
                weixinUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                weixinUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                weixinUserInfo.setCity(jsonObject.getString("city"));
                // 用户的语言，简体中文为zh_CN
                weixinUserInfo.setLanguage(jsonObject.getString("language"));
                // 用户头像
                weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            } catch (Exception e) {
                if (0 == weixinUserInfo.getSubscribe()) {
                    log.error("用户{}已取消关注", weixinUserInfo.getOpenId());
                } else {
                    int errorCode = jsonObject.getInt("errcode");
                    String errorMsg = jsonObject.getString("errmsg");
                    log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
                }
            }
        }
        return weixinUserInfo;
    }

    /**
     * 获取关注者列表
     *
     * @param accessToken 调用接口凭证
     * @param nextOpenId 第一个拉取的openId，不填默认从头开始拉取
     * @return WeixinUserList
     */
    @SuppressWarnings( { "unchecked", "deprecation" })
    public static WeixinUserList getUserList(String accessToken, String nextOpenId) {
        WeixinUserList weixinUserList = null;

        if (null == nextOpenId)
            nextOpenId = "";

        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", nextOpenId);
        // 获取关注者列表
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                weixinUserList = new WeixinUserList();
                weixinUserList.setTotal(jsonObject.getInt("total"));
                weixinUserList.setCount(jsonObject.getInt("count"));
                weixinUserList.setNextOpenId(jsonObject.getString("next_openid"));
                JSONObject dataObject = (JSONObject) jsonObject.get("data");
                weixinUserList.setOpenIdList(JSONArray.toList(dataObject.getJSONArray("openid"), List.class));
            } catch (JSONException e) {
                weixinUserList = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取关注者列表失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return weixinUserList;
    }
}
