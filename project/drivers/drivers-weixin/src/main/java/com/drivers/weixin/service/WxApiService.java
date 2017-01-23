package com.drivers.weixin.service;

import com.drivers.weixin.common.bean.WxPayBaseIn;
import com.drivers.weixin.common.bean.WxpayUnifiedOrderIn;
import com.drivers.weixin.common.bean.WxpayUnifiedOrderOut;

/**
 * Created by xhuji on 2016/10/12.
 */
public interface WxApiService {


    /**
     * 统一下单:  https://api.mch.weixin.qq.com/pay/unifiedorder
     * 不需要证书 参考https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
     *
     * @param in
     * @return
     */
    public WxpayUnifiedOrderOut unifiedorder(WxpayUnifiedOrderIn in);
    public String createWxSign(WxPayBaseIn in, String partnerKey);
}
