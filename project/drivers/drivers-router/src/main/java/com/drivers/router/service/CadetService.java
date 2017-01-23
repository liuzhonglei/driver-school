package com.drivers.router.service;

import com.drivers.entity.Cadet;
import com.drivers.router.web.request.CadetReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.CadetResp;
import com.drivers.router.web.response.StatisticsCadetNumResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
public interface CadetService {

    void save(final Request<Cadet> request, Response<Long> response);

    void batchSave(final Request<List<Cadet>> request, Response<Integer> response);

    void findAllBySearch(final CadetReq request, PagerResponse<CadetResp> response);

    void statisticsCadetNum(StatisticsReq request, PagerResponse<List<StatisticsCadetNumResp>> response);

    void invalid(Request<Long> request, PagerResponse<Integer> response, String dataUpdater);

    void batchInvalid(Request<List<Long>> request, Response<Integer> response,String dataUpdater);

    void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response);

    void bindWeixin(Request<Cadet> request, Response<Integer> response);

    void relateCoach(Request<Cadet> request, Response<Integer> response);

    void unbindWeixin(Request<Cadet> request, Response<Integer> response);
}
