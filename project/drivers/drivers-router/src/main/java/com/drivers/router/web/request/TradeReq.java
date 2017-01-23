package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;
import lombok.ToString;

/**
 * Created by xhuji on 2016/11/25.
 */
@Data
@ToString
public class TradeReq extends PagerRequest{
    /**
     * 用户在指定唯一标识类型中的字段值
     */
    private String userUnique;
    /**
     * 订单号
     */
    private String outTradeNo;
    /**
     * 支付订单号
     */
    private String transactionNo;
    /**
     * 预付单号
     */
    private String prepayId;
}
