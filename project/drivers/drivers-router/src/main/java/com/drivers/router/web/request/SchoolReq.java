package com.drivers.router.web.request;

import com.drivers.router.web.request.base.PagerRequest;
import lombok.Data;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
@Data
public class SchoolReq  extends PagerRequest {

    private Long id;

    private String name;

    private String mobile;

    private String phone;

    private String email;

    private String addr;

    private String introduction;
}
