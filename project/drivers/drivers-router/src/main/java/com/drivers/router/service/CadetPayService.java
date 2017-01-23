package com.drivers.router.service;

import com.drivers.entity.Cadet;
import com.drivers.entity.CadetPay;
import com.drivers.router.web.request.CadetPayReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetPayResp;
import com.drivers.router.web.response.StatisticsCadetPayResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface CadetPayService {

    void save(Request<CadetPay> request, Response<Integer> response);

    void invalid(Request<Long> request, PagerResponse<Integer> response, String dataUpdater);

    void update(Request<CadetPay> request, Response<Integer> response);

    void findOneByOpenId(Request<String> request, Response<CadetPayResp> response);

    void findAllBySearch(final CadetPayReq request, PagerResponse<CadetPayResp> response);

    void statisticsAmount(final StatisticsReq request, PagerResponse<List<StatisticsCadetPayResp>> response);


}
