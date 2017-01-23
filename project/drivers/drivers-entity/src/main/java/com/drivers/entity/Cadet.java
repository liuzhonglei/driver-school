package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cadet")
@Data
public class Cadet {
    @Transient
    private CadetCourse cadetCourse;
    @Transient
    private CadetPay cadetPay;
    @Transient
    private Coach coach;

    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 驾驶员数据ID
     */
    private Long coachId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
     * 电话号码
     */
    private String mobile;

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
     * 身份证号码
     */
    @Column(name = "idcard_num")
    private String idcardNum;
    /**
     * 车型
     */
    private String model;
    /**
     * 地址
     */
    private String addr;
    /**
     * 报名时间
     */
    private ZonedDateTime enrolDatetime;
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