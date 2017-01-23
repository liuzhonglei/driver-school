package com.medal.weixin.sdk.service;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;

import java.util.Map;

/**
 * Created by xhuji on 2016/10/23.
 */
public interface ClickHandle {
    BaseMessageResp handle(Map<String, String> requestMap);
}
