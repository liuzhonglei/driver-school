package com.drivers.weixin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static org.apache.naming.SelectorContext.prefix;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/1 上午10:16
 */
@Data
@Component
@ConfigurationProperties("api.data")
public class ApiDataProperties {

    private long keruyunBrandId;

    private String aliscanTimeout;

    private String sysProviderId;

    private String domain;

    private long kryAppPayBrandId;

    private String payPrefix;

    private String kryReceivingAppId;

    private String kryReceivingMchId;

    private String kryReceivingPartnerKey;

    private String kryReceivingTencentCertName;

    private String kryTencentCertName;

    private String refundPrefix;

    private String kryTencentCaCertName;

    private String commonKey;


}
