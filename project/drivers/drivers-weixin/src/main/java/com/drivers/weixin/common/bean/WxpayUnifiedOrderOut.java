package com.drivers.weixin.common.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author liangb
 * @version 1.0
 * @date 16/8/11 下午3:32
 */
@Data
public class WxpayUnifiedOrderOut extends WxPayBaseOut {

    @XStreamAlias("prepay_id")
    private String prepayId;

    @XStreamAlias("code_url")
    private String codeUrl;
}
