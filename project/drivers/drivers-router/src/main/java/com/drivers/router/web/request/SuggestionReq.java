package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/11.
 */
@Data
public class SuggestionReq extends PagerRequest {

    private String name;

    private String mobile;

    private Integer businessStatus;

    private ZonedDateTime dataCreateDatetime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;
}
