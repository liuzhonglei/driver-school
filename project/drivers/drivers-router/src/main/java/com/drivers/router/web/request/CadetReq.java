package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;
import lombok.ToString;

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
@ToString
public class CadetReq  extends PagerRequest {

    private Long id;

    private String name;

    private String mobile;

    private String weixinNum;

    private String idcardNum;
    /**
     * 数据创建时间->学员注册时间
     */
    private ZonedDateTime dataCreateDatetime;
}
