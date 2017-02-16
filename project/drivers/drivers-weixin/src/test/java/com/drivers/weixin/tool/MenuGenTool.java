package com.drivers.weixin.tool;

import com.medal.weixin.sdk.client.MenuClient;
import com.medal.weixin.sdk.client.TokenClient;
import com.medal.weixin.sdk.common.ButtonType;
import com.medal.weixin.sdk.menu.*;
import com.medal.weixin.sdk.pojo.Token;
import com.medal.weixin.sdk.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/5
 */
@Slf4j
public class MenuGenTool {
    /**
     * 组装菜单数据
     * TODO: 后台配置或配置文件
     * @return
     */
    public static Menu getMenu(String appId,String redirectUrl) {
        String url = "http://msrdjxx.com/";
//        String url = "http://xhujinjun.xicp.net/";
        //菜单:我要学车
        ViewButton schoolIntrodButton = new ViewButton();
        schoolIntrodButton.setName("驾校简介");
        schoolIntrodButton.setType(ButtonType.VIEW.getValue());
        schoolIntrodButton.setUrl(url + "index.html");

        ClickButton feeButton = new ClickButton();
        feeButton.setName("学车费用");
        feeButton.setType(ButtonType.Click.getValue());
        feeButton.setKey("feeButton");

        ClickButton addrButton = new ClickButton();
        addrButton.setName("驾校地址");
        addrButton.setType(ButtonType.Click.getValue());
        addrButton.setKey("addrButton");

        //OAuth2.网页授权

        ViewButton singupButton = new ViewButton();
        singupButton.setName("报名缴费");
        singupButton.setType(ButtonType.VIEW.getValue());
        String oauthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
        oauthUrl = oauthUrl.replace("APPID", appId);
        oauthUrl = oauthUrl.replace("REDIRECT_URI", CommonUtil.urlEncodeUTF8(redirectUrl));
        oauthUrl = oauthUrl.replace("SCOPE", "snsapi_userinfo");
        singupButton.setUrl(oauthUrl);

        ComplexButton wantLearnButton = new ComplexButton();
        wantLearnButton.setName("我要学车");
        wantLearnButton.setSub_button(new Button[] { schoolIntrodButton, feeButton, addrButton, singupButton });

        //菜单: 正在学车
        ClickButton payStatusButton = new ClickButton();
        payStatusButton.setName("缴费情况");
        payStatusButton.setType(ButtonType.Click.getValue());
        payStatusButton.setKey("payStatusButton");

        ClickButton learnStatusButton = new ClickButton();
        learnStatusButton.setName("学车情况");
        learnStatusButton.setType(ButtonType.Click.getValue());
        learnStatusButton.setKey("learnStatusButton");

        ClickButton coachInfoButton = new ClickButton();
        coachInfoButton.setName("教练信息");
        coachInfoButton.setType(ButtonType.Click.getValue());
        coachInfoButton.setKey("coachInfoButton");

        ComplexButton learningButton = new ComplexButton();
        learningButton.setName("正在学车");
        learningButton.setSub_button(new Button[] { payStatusButton, learnStatusButton,coachInfoButton });

        //菜单: 更多
        ViewButton documentButton = new ViewButton();
        documentButton.setName("新预约流程");
        documentButton.setType(ButtonType.VIEW.getValue());
        documentButton.setUrl(url + "document.html");

        ViewButton contactUsButton = new ViewButton();
        contactUsButton.setName("联系我们");
        contactUsButton.setType(ButtonType.VIEW.getValue());
        contactUsButton.setUrl(url + "contact.html");

        ViewButton complaintButton = new ViewButton();
        complaintButton.setName("投诉建议");
        complaintButton.setType(ButtonType.VIEW.getValue());
        complaintButton.setUrl(url + "suggestion.html");

        ComplexButton moreButton = new ComplexButton();
        moreButton.setName("更多");
        moreButton.setSub_button(new Button[] { documentButton, contactUsButton, complaintButton });

        /**
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
         *
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { wantLearnButton, learningButton, moreButton });
        return menu;
    }

    public static void main(String[] args) {
        // 第三方用户唯一凭证
        String appId = "wxca16c1bd1827f5c6";
        // 第三方用户唯一凭证密钥
        String appSecret = "d5badab28926b969f770317d3a5f11eb";
        String redirectUrl = "http://msrdjxx.com/weixin/oauth";
//        String redirectUrl = "http://xhujinjun.xicp.net/weixin/oauth";

        // 调用接口获取access_token
        Token at = TokenClient.getToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            boolean result = MenuClient.createMenu(getMenu(appId,redirectUrl), at.getAccessToken());

            // 判断菜单创建结果
            if (result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }
}
