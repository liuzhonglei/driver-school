package com.drivers.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/11/23.
 */
@Table(name = "trade")
@Data
@ToString
public class Trade {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_unique_type")
    private Integer userUniqueType;

    @Column(name = "user_unique")
    private String userUnique;

    @Column(name = "ip")
    private String ip;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "mch_id")
    private String mchId;

    @Column(name = "device_info")
    private String deviceInfo;

    @Column(name = "goods")
    private String goods;

    @Column(name = "out_trade_no")
    private String outTradeNo;

    @Column(name = "order_fee")
    private Integer orderFee;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "prepay_id")
    private String prepayId;

    @Column(name = "sign_type")
    private String signType;

    @Column(name = "sign")
    private String sign;

    @Column(name = "nonce_str")
    private String nonceStr;

    @Column(name = "time_stamp")
    private String timeStamp;
    /**
     * 数据创建者
     */
    @Column(name = "data_creator")
    private String dataCreator;

    /**
     * 数据更新者
     */
    @Column(name = "data_updater")
    private String dataUpdater;

    /**
     * 数据创建日期时间
     */
    @Column(name = "data_create_datetime")
    private ZonedDateTime dataCreateDatetime;

    /**
     * 数据更新日期时间
     */
    @Column(name = "data_update_datetime")
    private ZonedDateTime dataUpdateDatetime;

    /**
     * 数据有效状态
     */
    @Column(name = "data_status")
    private Boolean dataStatus;
}
