package com.drivers.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/9/8.
 */
@Table(name = "coach")
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 身份证号码
     */
    @Column(name = "idcard_num")
    private String idcardNum;
    /**
     * 电话号码1
     */
    private String mobile;
    /**
     * 电话号码2
     */
    private String mobile2;
    /**
     * 车型
     */
    private String model;

    /**
     * 用户的昵称(微信)
     */
    @Column(name = "wx_nickname")
    private String wxNickname;
    /**
     * 用户的标识，对当前公众号唯一
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

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
