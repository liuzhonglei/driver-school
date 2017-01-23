package com.drivers.router.service;

import com.drivers.entity.Coach;
import com.drivers.router.web.request.CoachReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.common.KeyValueResp;

import java.util.List;


/**
 * Created by xhuji on 2016/8/28.
 */
public interface CoachService {

    void findAllBySearch(final CoachReq request, PagerResponse<Coach> response);

    void findByCadetOpenId(Request<String> request, Response<Coach> response);

    void save(Request<Coach> request, Response<Integer> response);

    void invalid(Request<Long> request, PagerResponse<Integer> response,String dataUpdater);

    void batchInvalid(Request<List<Long>> request, Response<Integer> response,String dataUpdater);

    void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response);

    void update(Request<Coach> request, Response<Integer> response);

    void getCoachDic(String name,Response<List<KeyValueResp>> response);

    void bindWeixin(Request<Coach> request, Response<Integer> response);

    void unbindWeixin(Request<Coach> request, Response<Integer> response);
}
