package com.drivers.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/11/23.
 */
@Table(name = "goods")
@Data
@ToString
public class Transaction {
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

    @Column(name = "pay_datetime")
    private String payDatetime;

    @Column(name = "mch_id")
    private String mchId;

    @Column(name = "device_info")
    private String deviceInfo;

    @Column(name = "sign_type")
    private String signType;

    @Column(name = "sign")
    private String sign;

    @Column(name = "is_subscribe")
    private String isSubscribe;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "bank_type")
    private String bankType;

    @Column(name = "total_fee")
    private Integer totalFee;

    @Column(name = "settlement_total_fee")
    private Integer settlementTotalFee;

    @Column(name = "fee_type")
    private String feeType;

    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "out_trade_no")
    private String outTradeNo;
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
