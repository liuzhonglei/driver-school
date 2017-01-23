package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;

/**
 * Created by xhuji on 2016/8/13.
 */
@Data
public class CadetPayReq  extends PagerRequest {

    private Long id;

    private String name;

    private String mobile;

    private String weixinNum;

    private String idcardNum;
}
