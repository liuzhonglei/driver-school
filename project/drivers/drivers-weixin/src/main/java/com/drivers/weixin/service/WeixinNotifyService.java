package com.drivers.weixin.service;

import java.util.Map;

/**
 * Created by xhuji on 2016/11/23.
 */
public interface WeixinNotifyService {

    boolean notify(Map<String,String> map);
}
