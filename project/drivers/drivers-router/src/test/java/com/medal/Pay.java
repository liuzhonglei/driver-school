package com.medal;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/17
 */
@Data
public class Pay {

    private String key;

    private Double pay;

    private ZonedDateTime dataUpdateDatetime;
}
