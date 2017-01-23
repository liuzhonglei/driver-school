package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.pojo.WeixinGroup;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by xhuji on 2016/10/21.
 */
@Slf4j
public class GroupClient {
    /**
     * 查询分组
     *
     * @param accessToken 调用接口凭证
     */
    @SuppressWarnings( { "unchecked", "deprecation" })
    public static List<WeixinGroup> getGroups(String accessToken) {
        List<WeixinGroup> weixinGroupList = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 查询分组
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                weixinGroupList = JSONArray.toList(jsonObject.getJSONArray("groups"), WeixinGroup.class);
            } catch (JSONException e) {
                weixinGroupList = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("查询分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return weixinGroupList;
    }

    /**
     * 创建分组
     *
     * @param accessToken 接口访问凭证
     * @param groupName 分组名称
     * @return
     */
    public static WeixinGroup createGroup(String accessToken, String groupName) {
        WeixinGroup weixinGroup = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 需要提交的json数据
        String jsonData = "{\"group\" : {\"name\" : \"%s\"}}";
        // 创建分组
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupName));

        if (null != jsonObject) {
            try {
                weixinGroup = new WeixinGroup();
                weixinGroup.setId(jsonObject.getJSONObject("group").getInt("id"));
                weixinGroup.setName(jsonObject.getJSONObject("group").getString("name"));
            } catch (JSONException e) {
                weixinGroup = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("创建分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return weixinGroup;
    }

    /**
     * 修改分组名
     *
     * @param accessToken 接口访问凭证
     * @param groupId 分组id
     * @param groupName 修改后的分组名
     * @return true | false
     */
    public static boolean updateGroup(String accessToken, int groupId, String groupName) {
        boolean result = false;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 需要提交的json数据
        String jsonData = "{\"group\": {\"id\": %d, \"name\": \"%s\"}}";
        // 修改分组名
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupId, groupName));

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
                log.info("修改分组名成功 errcode:{} errmsg:{}", errorCode, errorMsg);
            } else {
                log.error("修改分组名失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }

    /**
     * 移动用户分组
     *
     * @param accessToken 接口访问凭证
     * @param openId 用户标识
     * @param groupId 分组id
     * @return true | false
     */
    public static boolean updateMemberGroup(String accessToken, String openId, int groupId) {
        boolean result = false;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        // 需要提交的json数据
        String jsonData = "{\"openid\":\"%s\",\"to_groupid\":%d}";
        // 移动用户分组
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, openId, groupId));

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
                log.info("移动用户分组成功 errcode:{} errmsg:{}", errorCode, errorMsg);
            } else {
                log.error("移动用户分组失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}
