package com.drivers.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cadet_pay")
@Data
public class CadetPay {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学员信息数据ID
     */
    @Column(name = "cadet_id")
    private Long cadetId;

    /**
     * 缴费状态
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 缴费金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 缴费日期时间
     */
    @Column(name = "pay_amount")
    private LocalDate payDatetime;
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

}