
package com.drivers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CashierPay implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accountType;  // 支付入账类型 （BRAND：品牌 SHOP：门店）

	private Long actualFee;  //    实际支付金额

	private String appid;  // 发起支付申请的应用id

	private Long brandId;  // 支付品牌id   

	private String buyerAccount;  // 付款账户   

	private Long couponFee;  // 支付平台减免金额   

	private Timestamp createTime = new Timestamp(System.currentTimeMillis());  //    

	private Long id;  //    

	private String isCollect ;  // 是否客如云代收 Y:客如云代收 N 非客如云代收

	private Integer notifyStatus;  // 通知状态  1:通知中;2:通知成功; 3:通知失败;   

	private Timestamp notifyTime;  // 客如云通知商户成功时间   

	private String outTradeNo;  // 商户提供的订单号   

	private Integer payChannel;  // 支付渠道 （1：客如云 2：威富通）

	private Long payFee;  // 支付金额 单位 分   

	private Integer payPlatform;  // 支付平台（-5：微信；-6支付宝；-7百度钱包 -8 直达号   

	private Integer payStatus;  // 支付状态，默认1:未支付；3支付成功；

	private Timestamp payTime;  // 支付时间   

	private Integer payType;  // 支付方式 1 网页支付；2 扫码支付 3：被扫支付；   

	private String sellerAccount;  // 收款账户   

	private Long shopId;  // 商户编号   

	private Integer status;  // 支付单状态，1:有效，2：无效

	private String transactionNo;  // 支付平台交易号   

	private Timestamp updateTime;  //    

	private String uuid;  // uuid   

}
