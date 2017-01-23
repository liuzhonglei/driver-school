package com.medal.weixin.sdk.client;

import com.medal.weixin.sdk.menu.Menu;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * Created by xhuji on 2016/10/20.
 */
@Slf4j
public class MenuClient {
    // 菜单创建（POST）
    private final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 菜单查询（GET）
    private final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 菜单删除（GET）
    private final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @param accessToken 凭证
     * @return true成功 false失败
     */
    public static boolean createMenu(Menu menu, String accessToken) {
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        return createMenu(jsonMenu,accessToken);
    }
    /**
     * 创建菜单
     *
     * @param jsonMenu 菜单json
     * @param accessToken 凭证
     * @return true成功 false失败
     */
    public static boolean createMenu(String jsonMenu, String accessToken) {
        boolean result = false;
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        // 发起POST请求创建菜单
        JSONObject jsonObject = HttpsUtil.httpsRequest(url, "POST", jsonMenu);
        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
            } else {
                result = false;
                log.error("创建菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
    /**
     * 查询菜单
     *
     * @param accessToken 凭证
     * @return
     */
    public static String getMenu(String accessToken) {
        String result = null;
        String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
        // 发起GET请求查询菜单
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            result = jsonObject.toString();
        }
        return result;
    }

    /**
     * 删除菜单
     *
     * @param accessToken 凭证
     * @return true成功 false失败
     */
    public static boolean deleteMenu(String accessToken) {
        boolean result = false;
        String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
        // 发起GET请求删除菜单
        JSONObject jsonObject = HttpsUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
            } else {
                result = false;
                log.error("删除菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}
