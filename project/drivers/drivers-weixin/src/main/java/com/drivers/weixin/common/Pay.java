package com.drivers.weixin.common;

import lombok.Data;
import lombok.ToString;

/**
 * Created by xhuji on 2016/10/29.
 */
@Data
@ToString
public class Pay {

    private String appId;

    private String timeStamp;

    private String nonceStr;

    private String pg;

    private String signType;

    private String paySign;

    private String openid;
}
