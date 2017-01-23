package com.drivers.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_manager")
@Data
public class SysManager {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 姓名
     */
    private String name;
    /**
     * sex
     */
    private Integer sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 手机号码
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