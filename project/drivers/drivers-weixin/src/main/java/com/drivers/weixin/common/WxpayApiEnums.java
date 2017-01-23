package com.drivers.weixin.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/19 下午5:35
 */
public class WxpayApiEnums {

    /**
     * 微信支付交易状态
     */
    public enum TradeStatus{

        SUCCESS,//—支付成功
        REFUND,//—转入退款
        NOTPAY,//—未支付
        CLOSED,//—已关闭
        REVOKED,//—已撤销（刷卡支付）
        USERPAYING,//--用户支付中
        PAYERROR,//--支付失败(其他原因，如银行返回失败)
        ;

        private static Map<String, TradeStatus> cachedMap = new HashMap<String, TradeStatus>();

        static {
            for (TradeStatus rc : TradeStatus.values()) {
                cachedMap.put(rc.name(), rc);
            }
        }

        public static TradeStatus get(String code) {
            return cachedMap.get(code);
        }

    }

    /**
     * 微信支付交易状态
     */
    public enum PayType{

        JSAPI,
        NATIVE,
        APP,
        MICROPAY;

        private static Map<String, PayType> cachedMap = new HashMap<String, PayType>();

        static {
            for (PayType rc : PayType.values()) {
                cachedMap.put(rc.name(), rc);
            }
        }

        public static PayType get(String code) {
            return cachedMap.get(code);
        }

    }


}
