package com.drivers.weixin.service;

import com.medal.weixin.sdk.pojo.SNSUserInfo;

/**
 * Created by xhuji on 2016/11/22.
 */
public interface WeixinOAuthService {

    SNSUserInfo getSNSUserInfo(String code);
}
