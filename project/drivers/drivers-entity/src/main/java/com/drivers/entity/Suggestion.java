package com.drivers.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;
@Table(name = "suggestion")
@Data
public class Suggestion {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 来源App
     */
    @Column(name = "app_type")
    private Integer appType;
    /**
     * 学员信息数据ID
     */
    @Column(name = "cadet_id")
    private Long cadetId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 投诉内容
     */
    private String content;

    /**
     * 业务状态
     */
    @Column(name = "business_status")
    private Integer businessStatus;

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
    private LocalDateTime dataCreateDatetime;

    /**
     * 数据更新日期时间
     */
    @Column(name = "data_update_datetime")
    private LocalDateTime dataUpdateDatetime;

    /**
     * 数据有效状态
     */
    @Column(name = "data_status")
    private Boolean dataStatus;

}