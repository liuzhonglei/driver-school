package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;

/**
 * Created by xhuji on 2016/8/28.
 */
@Data
public class CoachReq extends PagerRequest {

    private String name;

    private String mobile;

    private String model;

}
