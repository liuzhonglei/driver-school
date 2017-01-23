package com.drivers.weixin.common.bean;

import lombok.Data;

/**
 * @author liangb
 * @version 1.0
 * @date 16/8/10 上午10:46
 */
@Data
public class WxPayBaseIn {

    private int isSubMch;  //是否开通受理商户支付  1 是  0 否

    private Long brandId;   //品牌id

}
