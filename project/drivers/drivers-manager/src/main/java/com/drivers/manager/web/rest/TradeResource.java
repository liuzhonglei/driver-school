package com.drivers.manager.web.rest;

import com.drivers.entity.Trade;
import com.drivers.router.service.TradeService;
import com.drivers.router.web.request.TradeReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhuji on 2016/11/25.
 */
@RestController
@RequestMapping("/api/trades")
@Slf4j
public class TradeResource extends BaseResource{
    @Autowired
    private TradeService tradeService;

    @RequestMapping(value = "_search/trades", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<Trade> getByPage( @Validated TradeReq request, BindingResult result){
        PagerResponse<Trade> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        tradeService.findAllBySearch(request,response);
        return response;
    }
}
