package com.drivers.router.web.request.base;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by xhuji on 2016/9/8.
 */
@Data
public class PagerRequest{

    @NotNull
    private Integer limit;

    @NotNull
    private Integer offset;

    private String sort;

    private String order;

}
