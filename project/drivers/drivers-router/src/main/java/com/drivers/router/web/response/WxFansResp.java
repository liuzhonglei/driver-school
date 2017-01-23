package com.drivers.router.web.response;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by xhuji on 2016/11/13.
 */
@Data
public class WxFansResp {

    private Long id;

    private String subscribe;

    private String openid;

    private String nickname;

    private String sex;

    private String city;

    private String country;

    private String province;

    private String language;

    private String headimgurl;

    private Timestamp subscribeTime;

    private String unionid;

    private String groupid;

    private String tagidList;
}
