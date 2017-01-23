package com.drivers.weixin.common;

import java.util.HashMap;
import java.util.Map;

/**
 * cashier_pay枚举集合
 * @author liangb
 * @version 1.0
 * @date 16/6/29 下午4:48
 */
public class CashierPayEnums {

    public static final int PAYMENT_TYPE_TRADE_SELL = 1;  //交易类型 交易支付,

    /**
     * 支付入账类型枚举
     */
    public enum AccountType{

        BRAND("BRAND","品牌")
        ,SHOP("SHOP","门店")
        ;
        private String code;
        private String message;

        private static Map<String, AccountType> cachedMap = new HashMap<String, AccountType>();

        static {
            for (AccountType rc : AccountType.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        AccountType(String code, String message){
            this.code = code;
            this.message = message;
        }

        public static AccountType get(String code) {
            return cachedMap.get(code);
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
                return message;
            }
    }

    /**
     * 支付渠道
     */
    public enum PayChannel{

        KE_RU_YUN(1,"客如云")
        ,WEI_FU_TONG(2,"威富通")
        ;
        private int code;
        private String message;

        private static Map<Integer, PayChannel> cachedMap = new HashMap<Integer, PayChannel>();

        static {
            for (PayChannel rc : PayChannel.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        PayChannel(int code, String message){
            this.code = code;
            this.message = message;
        }

        public static PayChannel get(int code) {
            return cachedMap.get(code);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
                return message;
            }
    }
    /**
     * 支付平台 （-5：微信；-6支付宝；-7百度钱包 -8 直达号
     */
    public enum PayPlatform{

        WEIXIN_PAY(-5,"微信")
        ,ALI_PAY(-6,"支付宝")
        ,BAIDU_PAY(-7,"百度钱包")
        ,ZHIDAHAO(-8,"直达号")
        ;
        private int code;
        private String message;

        private static Map<Integer, PayPlatform> cachedMap = new HashMap<Integer, PayPlatform>();

        static {
            for (PayPlatform rc : PayPlatform.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        PayPlatform(int code, String message){
            this.code = code;
            this.message = message;
        }

        public static PayPlatform get(int code) {
            return cachedMap.get(code);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
                return message;
            }
    }
    /**
     * 支付状态，默认1:未支付；3支付成功 9支付失败；
     */
    public enum PayStatus{

        UN_PAY(1,"UNPAID")
        ,PAID(3,"PAYSUCCESS")
        ,PAY_ERROR(9,"PAYERROR")
        ;
        private int code;
        private String message;

        private static Map<Integer, PayStatus> cachedMap = new HashMap<Integer, PayStatus>();

        static {
            for (PayStatus rc : PayStatus.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        PayStatus(int code, String message){
            this.code = code;
            this.message = message;
        }

        public static PayStatus get(int code) {
            return cachedMap.get(code);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
                return message;
            }
    }
    /**
     * 支付方式 1 网页支付；2 扫码支付 3：被扫支付；
     */
    public enum PayType{

        WEB_PAGE(1,"网页支付")
        ,SCAN_CODE(2,"扫码支付")
        ,SHOW_CODE(3,"被扫支付")
        ,APP(5,"APP支付")
        ,WEB_PAGE_MOBILE(10,"手机网页支付")
        ;

        private int code;
        private String message;

        private static Map<Integer, PayType> cachedMap = new HashMap<Integer, PayType>();

        static {
            for (PayType rc : PayType.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        PayType(int code, String message){
            this.code = code;
            this.message = message;
        }

        public static PayType get(int code) {
            return cachedMap.get(code);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
                return message;
            }
    }

    /**
     * 通知状态  1:通知中;2:通知成功; 3:通知失败;
     */
    public enum NotifyStatus{

        PROCESSING(1,"通知中")
        ,SUCCESS(2,"通知成功")
        , FAIL(3,"通知失败")
        ;
        private int code;
        private String message;

        private static Map<Integer, NotifyStatus> cachedMap = new HashMap<Integer, NotifyStatus>();

        static {
            for (NotifyStatus rc : NotifyStatus.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        NotifyStatus(int code, String message){
            this.code = code;
            this.message = message;
        }

        public static NotifyStatus get(int code) {
            return cachedMap.get(code);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * 通知状态  1:通知中;2:通知成功; 3:通知失败;
     */
    public enum PlatformType{

        PC("PC","pc端")
        ,MOBILE("MOBILE","手机端")
        ;
        private String code;
        private String message;

        private static Map<String, PlatformType> cachedMap = new HashMap<String, PlatformType>();

        static {
            for (PlatformType rc : PlatformType.values()) {
                cachedMap.put(rc.code, rc);
            }
        }

        PlatformType(String code, String message){
            this.code = code;
            this.message = message;
        }

        public static PlatformType get(String code) {
            return cachedMap.get(code);
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}
