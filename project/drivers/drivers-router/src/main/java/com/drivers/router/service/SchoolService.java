package com.drivers.router.service;

import com.drivers.entity.School;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;

import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
public interface SchoolService {

    void findAll(Response<School> response);

    void updateSchool(Request<School> request, Response<Integer> response);
}
