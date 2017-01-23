package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import javax.persistence.*;
@Table(name = "school")
@Data
public class School {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 驾校名称
     */
    private String name;

    /**
     * 驾校logo地址
     */
    @Column(name = "logo_url")
    private String logoUrl;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 驾校地址
     */
    private String addr;
    /**
     * 宣传口号
     */
    private String slogan;
    /**
     * 驾校简介
     */
    private String introduction;
    /**
     * 管理员
     */
    private String administrators;
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