package com.drivers.router.service;

import com.drivers.entity.CadetCourse;
import com.drivers.router.web.request.CadetCourseReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetCourseResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface CadetCourseService {

    void save(Request<CadetCourse> request, Response<Integer> response);

    void invalid(Request<Long> request, PagerResponse<Integer> response, String dataUpdater);

    void update(Request<CadetCourse> request, Response<Integer> response);

    void findAllBySearch(final CadetCourseReq request, PagerResponse<CadetCourseResp> response);

    void findOneByOpenId(Request<String> request, Response<CadetCourseResp> response);
}
