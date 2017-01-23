package com.drivers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author liangb
 * @version 1.0
 * @date 16/7/18 下午5:07
 */
@Table(name = "wx_merchant")
@Data
//@Builder
@NoArgsConstructor
public class WxMerchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "app_secret")
    private String appSecret;

    @Column(name = "pay_sign_key")
    private String paySignKey;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "partner_key")
    private String partnerKey;

    @Column(name = "password")
    private String password;

    @Column(name = "menu_open_type")
    private Integer menuOpenType;

    @Column(name = "cert_url")
    private String certUrl;

    @Column(name = "is_open_sub_mch")
    private Integer isOpenSubMch;

    @Column(name = "access_token")
    private String accessToken;

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
