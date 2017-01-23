package com.drivers.router.service;

import com.drivers.entity.SchoolTuition;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.SchoolTuitionResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface SchoolTuitionService {

    void findAllBySearch(Response<SchoolTuitionResp> response);

    void updateSchoolTuition(Request<SingleFieldUpdateReq> request, Response<Integer> response);
}
