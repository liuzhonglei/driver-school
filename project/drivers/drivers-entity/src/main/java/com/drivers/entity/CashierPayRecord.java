
package com.drivers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class CashierPayRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String accountType;  // 支付入账类型 （BRAND：品牌 SHOP：门店 默认brand）
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());  //
	private Long id;  //
	private String isCollect;  // 是否代收
	private String notifyUrl;  // 支付结果通知url
	private String pageUrl;  // 商户请求页面通知地址
	private Integer payChannel;  // 支付渠道 （1：客如云 2：威富通 默认1）
	private Long payFee;  // 支付金额 单位 分
	private Long payId;  // 支付单id对应cashier_pay表的id
	private Integer payPlatform;  // 支付平台（-5：微信；-6支付宝；-7百度钱包 -8 直达号
	private Integer payType;  // 支付方式 1 网页支付；2 扫码支付 3：被扫支付；
	private String remark;  // 备注
	private Integer status;  // 状态，1:有效 2:无效(默认:有效)
	private String transactionNo;  // 支付平台交易号
	private Timestamp updateTime;  //
	private String uuid;  // uuid

}
