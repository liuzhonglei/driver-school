package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;

/**
 * Created by xhuji on 2016/11/13.
 */
@Data
public class WxFansReq extends PagerRequest {

    private String openId;

    private String nickname;

    private Integer sex;
}
