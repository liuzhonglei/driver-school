package com.drivers.weixin.web;

import com.drivers.weixin.common.bean.WxpayUnifiedOrderOut;
import com.medal.weixin.sdk.util.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * Created by xhuji on 2016/10/25.
 */
@Slf4j
public class PayClient {

    public static String jsPay(String xml){
        WxpayUnifiedOrderOut orderOut = null;

        String requestUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String str = HttpsUtil.httpsRequestForString(requestUrl, "GET", xml);
//        if (null != jsonObject) {
//            orderOut = new WxpayUnifiedOrderOut();
////            orderOut.orderOut
//        }
        return str;
    }
}
