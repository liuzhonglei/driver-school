package com.drivers.weixin.common;

import lombok.Data;

/**
 * Created by xhuji on 2016/10/12.
 */
@Data
public class PayBaseParam {
    private Long payFee;
    private String isCollect;
    private String accountType;
    private String outTradeNo;
    private Integer payChannel ;
    private String notifyUrl;

    private Integer platform;
    private Long shopId;
    private Long appid;
    private Long brandId;
    private Integer payType;
    private String returnUrl;
}
