package com.drivers.router.web.response;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/13.
 */
@Data
public class CadetCourseResp {

    //--------------学员基本信息
    private Long id;

    private String username;

    private String name;

    private Integer sex;

    private String birthday;

    private String mobile;

    private String wxNickname;

    private String wxOpenid;

    private String idcardNum;

    //  学员课程情况
    private Long cadetCourseId;

    private Long cadetId;

    private Integer course;

    private String dataUpdater;

    private ZonedDateTime dataUpdateDatetime;
}
