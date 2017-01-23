package com.drivers.router.web.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/13.
 */
@Data
public class CadetPayResp {

    //--------------学员基本信息
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer sex;

    private String birthday;

    private String mobile;

    private String wxNickname;

    private String wxOpenid;

    private String idcardNum;

    //  学员缴费信息
    private Long cadetPayId;

    private Long cadetId;

    private Integer payStatus;

    private BigDecimal payAmount;

    private ZonedDateTime payDatetime;

}
