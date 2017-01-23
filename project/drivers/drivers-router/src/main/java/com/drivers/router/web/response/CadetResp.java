package com.drivers.router.web.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@Data
public class CadetResp {
    //--------------学员基本信息
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer sex;

    private LocalDate birthday;

    private String mobile;

    private String weixinNum;

    private String idcardNum;

    private String model;

    private String wxNickname;

    private String wxOpenid;

    private String dataUpdater;

    private LocalDateTime dataCreateDatetime;

    private Integer dataStatus;

    //  学员缴费信息
    private Long cadetPayId;

    private Integer payStatus;

    //  学员课程情况
    private Long cadetCourseId;

    private Integer course;

    //教练信息
    private String driverName;

    private String driverMobile;
}
