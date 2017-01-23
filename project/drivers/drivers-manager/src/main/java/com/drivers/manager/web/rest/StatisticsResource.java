package com.drivers.manager.web.rest;

import com.drivers.router.service.CadetPayService;
import com.drivers.router.service.CadetService;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.response.StatisticsCadetNumResp;
import com.drivers.router.web.response.StatisticsCadetPayResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xhuji on 2016/9/24.
 */
@RestController
@RequestMapping("/api/statistics")
public class StatisticsResource extends BaseResource{

    @Autowired
    private CadetPayService cadetPayService;
    @Autowired
    private CadetService cadetService;

    @RequestMapping(value = "/cadet/pay", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StatisticsCadetPayResp> statisticsCadetPayAmount(@Validated StatisticsReq request, BindingResult result){
        PagerResponse<List<StatisticsCadetPayResp>> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return null;
        }
        cadetPayService.statisticsAmount(request,response);
        return response.getContent();
    }
    @RequestMapping(value = "/cadet/num", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StatisticsCadetNumResp> statisticsCadetNum(@Validated StatisticsReq request, BindingResult result){
        PagerResponse<List<StatisticsCadetNumResp>> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return null;
        }
        cadetService.statisticsCadetNum(request,response);
        return response.getContent();
    }

}
