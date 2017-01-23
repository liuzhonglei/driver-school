package com.drivers.weixin.common.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author liangb
 * @version 1.0
 *
 * <xml>
<appid>wx2421b1c4370ec43b</appid>
<attach>支付测试</attach>
<body>JSAPI支付测试</body>
<mch_id>10000100</mch_id>
<detail><![CDATA[{ "goods_detail":[ { "goods_id":"iphone6s_16G", "wxpay_goods_id":"1001", "goods_name":"iPhone6s 16G", "quantity":1, "price":528800, "goods_category":"123456", "body":"苹果手机" }, { "goods_id":"iphone6s_32G", "wxpay_goods_id":"1002", "goods_name":"iPhone6s 32G", "quantity":1, "price":608800, "goods_category":"123789", "body":"苹果手机" } ] }]]></detail>
<nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
<notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>
<openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
<out_trade_no>1415659990</out_trade_no>
<spbill_create_ip>14.23.150.211</spbill_create_ip>
<total_fee>1</total_fee>
<trade_type>JSAPI</trade_type>
<sign>0CB01533B8C1EF103065174F50BCA001</sign>
</xml>
 * @date 16/8/11 下午3:32
 */
@Data
public class WxpayUnifiedOrderIn extends WxPayBaseIn {
    /**
     * 字段名: 公众账号ID
     * 变量名: appid
     * 必填: 是
     * 类型: String(32)
     * 示例值: wxd678efh567hg6787
     * 描述: 微信分配的公众账号ID（企业号corpid即为此appId）
     *
     * 事先配置好，通过配置文件或数据库获得(如:wx_merchant)
     */
    @XStreamAlias("appid")
    private String appid;

    /**
     * 字段名: 商户号
     * 变量名: mch_id
     * 必填: 是
     * 类型: String(32)
     * 示例值: 1230000109
     * 描述: 微信支付分配的商户号
     *
     * 事先配置好，通过配置文件或数据库获得(如:wx_merchant)
     */
    @XStreamAlias("mch_id")
    private String mchId;
    /**
     * 字段名: 设备号
     * 变量名: device_info
     * 必填: 否
     * 类型: String(32)
     * 示例值: 013467007045764
     * 描述: 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     *
     * 请求参数，默认为"WEB"
     */
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 字段名: 随机字符串
     * 变量名: nonce_str
     * 必填: 是
     * 类型: String(32)
     * 示例值: 5K8264ILTKCH16CQ2502SI8ZNMTM67VS
     * 描述: 随机字符串，不长于32位。推荐随机数生成算法https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
     *
     * 算法封装（参考：）
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 字段名: 签名
     * 变量名: sign
     * 必填: 是
     * 类型: String(32)
     * 示例值: C380BEC2BFD727A4B6845133519F3AD6
     * 描述:签名，详见https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
     *
     * 算法封装（参考：）
     */
    @XStreamAlias("sign")
    private String sign;
    /**
     * 字段名: 商品描述
     * 变量名: body
     * 必填: 是
     * 类型: String(128)
     * 示例值:
     * 描述:
     *
     * 请求参数
     */
    @XStreamAlias("body")
    private String body;
    /**
     * 字段名: 商品详情
     * 变量名: body
     * 必填: 否
     * 类型: String(6000)
     * 示例值:
     * 描述:
     *
     * 请求参数
     */
    @XStreamAlias("detail")
    private String detail;
    /**
     * 字段名: 附加数据
     * 变量名: attach
     * 必填: 否
     * 类型: String(127)
     * 示例值: 深圳分店
     * 描述: 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     *
     * 请求参数
     */
    @XStreamAlias("attach")
    private String attach;
    /**
     * 字段名: 商户订单号
     * 变量名: out_trade_no
     * 必填: 是
     * 类型: String(32)
     * 示例值: 20150806125346
     * 描述: 商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     *
     * 请求参数或后台生成
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 字段名: 货币类型
     * 变量名: fee_type
     * 必填: 否
     * 类型: String(16)
     * 示例值: CNY
     * 描述: 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     *
     * 请求参数(默认CNY)
     */
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 字段名: 总金额
     * 变量名: total_fee
     * 必填: 是
     * 类型: Int
     * 示例值: 888
     * 描述: 订单总金额，单位为分，详见支付金额(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     *
     * 请求参数
     */
    @XStreamAlias("total_fee")
    private Long totalFee;

    /**
     * 字段名: 终端IP
     * 变量名: spbill_create_ip
     * 必填: 是
     * 类型: String(16)
     * 示例值: 123.12.12.123
     * 描述: APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     *
     * 请求参数
     */
    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;
    /**
     * 字段名: 交易起始时间
     * 变量名: time_start
     * 必填: 否
     * 类型: String(14)
     * 示例值: 20091225091010
     * 描述: 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     *
     * 后台生成
     */
    @XStreamAlias("time_start")
    private String timeStart;
    /**
     * 字段名: 交易结束时间
     * 变量名: time_expire
     * 必填: 否
     * 类型: String(14)
     * 示例值: 20091227091010
     * 描述:订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     *       注意：最短失效时间间隔必须大于5分钟
     *
     * 后台生成
     */
    @XStreamAlias("time_expire")
    private String timeExpire;
    /**
     * 字段名: 商品标记
     * 变量名: goods_tag
     * 必填: 否
     * 类型: String(32)
     * 示例值: WXG
     * 描述: 商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠(https://pay.weixin.qq.com/wiki/doc/api/tools/sp_coupon.php?chapter=12_1)
     */
    @XStreamAlias("goods_tag")
    private String goodsTag;

    /**
     * 字段名: 通知地址
     * 变量名: notify_url
     * 必填: 是
     * 类型: String(256)
     * 示例值: http://www.weixin.qq.com/wxpay/pay.php
     * 描述: 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     *
     * 事先配置好，通过配置文件或数据库获得(如:wx_merchant)
     */
    @XStreamAlias("notify_url")
    private String notifyUrl;
    /**
     * 字段名: 交易类型
     * 变量名: trade_type
     * 必填: 是
     * 类型: String(16)
     * 示例值: JSAPI
     * 描述: 取值如下：JSAPI，NATIVE，APP，详细说明见参数规定(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2)
     */
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 字段名: 商品ID
     * 变量名: product_id
     * 必填: 否
     * 类型: String(32)
     * 示例值: 12235413214070356458058
     * 描述: trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    @XStreamAlias("product_id")
    private Long productId;

    /**
     * 字段名: 指定支付方式
     * 变量名: limit_pay
     * 必填: 否
     * 类型: String(32)
     * 示例值: no_credit
     * 描述: no_credit--指定不能使用信用卡支付
     */
    @XStreamAlias("limit_pay")
    private String limit_pay;

    /**
     * 字段名: 用户标识
     * 变量名:
     * 必填:
     * 类型: String(128)
     * 示例值: oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * 描述: trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid(https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_4)】。企业号请使用【企业号OAuth2.0接口(qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3)】获取企业号内成员userid，再调用【企业号userid转openid接口(qydev.weixin.qq.com/wiki/index.php?title=OAuth%E9%AA%8C%E8%AF%81%E6%8E%A5%E5%8F%A3)】进行转换
     */
    @XStreamAlias("openid")
    private String openid;

    //-- 扩展
    /**
     * 字段名: 平台
     * 变量名:
     * 必填:
     * 类型:
     * 示例值:
     * 描述:
     */
    @XStreamAlias("sub_openid")
    private String subOpenid;

    /**
     * 字段名: 平台
     * 变量名:
     * 必填:
     * 类型:
     * 示例值:
     * 描述:
     */
    @XStreamAlias("sub_appid")
    private String subAppid;
    /**
     * 字段名: 平台
     * 变量名:
     * 必填:
     * 类型:
     * 示例值:
     * 描述:
     */
    @XStreamAlias("sub_mch_id")
    private String subMchId;
}
