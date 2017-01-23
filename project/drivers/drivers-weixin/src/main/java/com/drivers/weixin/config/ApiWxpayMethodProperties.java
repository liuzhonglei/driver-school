package com.drivers.weixin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/19 下午3:27
 */
@Data
@Component
@ConfigurationProperties("api.wxpay.method")
public class ApiWxpayMethodProperties {

    private String orderQuery;

    private String reverse;

    private String unifiedOrder;

    private String kryNotifyUrl;

    private String kryNotifyUrlOld;

    private String closeOrder;

    private String microPay;

    private String refund;

    private String refundOld;

    private String refundQuery;

    private String refundQueryOld;
}
