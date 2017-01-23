package com.drivers.router.web.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/9/11.
 */
@Data
public class SchoolTuitionResp {
    private Long id;

    private String name;

    private BigDecimal tuition;

    private String tuitionExplain;

    private String dataUpdater;

    private ZonedDateTime dataUpdateDatetime;
}
