package com.drivers.weixin.web.response;

import lombok.Data;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/18 下午2:38
 */
@Data
public class WxpayWebResp {

    private String payParam;//支付参数json格式

    private String outTradeNo;
}
