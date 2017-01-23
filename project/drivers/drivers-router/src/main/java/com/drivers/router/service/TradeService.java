package com.drivers.router.service;

import com.drivers.entity.Trade;
import com.drivers.router.web.request.TradeReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;

/**
 * Created by xhuji on 2016/11/25.
 */
public interface TradeService {

    void findAllBySearch(final TradeReq request, PagerResponse<Trade> response);

}
