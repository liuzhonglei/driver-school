package com.drivers.weixin.web.rest;

import com.medal.weixin.sdk.client.MenuClient;
import com.medal.weixin.sdk.client.TokenClient;
import com.medal.weixin.sdk.pojo.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信自定义菜单管理器
 *
 * Created by xhuji on 2016/9/3.
 */
@Slf4j
@RestController
@RequestMapping( value = "/weixinMenuManager")
public class WeixinMenuRest {

    String appId = "wxca16c1bd1827f5c6";
    String appSecret = "d5badab28926b969f770317d3a5f11eb";
    /**
     * /weixinMenuManager/generate  GET
     * 生成微信菜单
     * @return
     */
    @RequestMapping(value = "/generate",method = RequestMethod.GET)
    public String generateMenu(String jsonmenu){
        String respMessage = "请求处理失败!";
        Token at = TokenClient.getToken(appId, appSecret);
        if (null != at) {
            // 调用接口创建菜单
            boolean result = MenuClient.createMenu(
                    jsonmenu,
                    at.getAccessToken());

            // 判断菜单创建结果
            if (result) {
                respMessage = "菜单创建成功！";
            }else {
                respMessage = "菜单创建失败，错误码：" + result;
            }
        }
        return respMessage;
    }
    @RequestMapping(value = "/getMenu",method = RequestMethod.GET)
    public String getMenus(){
        String respMessage = "请求处理失败!";
        Token at = TokenClient.getToken(appId, appSecret);
        if (null != at) {
            respMessage = MenuClient.getMenu(at.getAccessToken());
        }
        return respMessage;
    }

    @RequestMapping(value = "/deleteMenu",method = RequestMethod.GET)
    public String deleteMenu(){
        String respMessage = "请求处理失败!";
        Token at = TokenClient.getToken(appId, appSecret);
        if (null != at) {
            boolean result = MenuClient.deleteMenu(at.getAccessToken());
            if (result) {
                respMessage = "菜单删除成功！";
            }else {
                respMessage = "菜单删除失败，错误码：" + result;
            }
        }
        return respMessage;
    }

}