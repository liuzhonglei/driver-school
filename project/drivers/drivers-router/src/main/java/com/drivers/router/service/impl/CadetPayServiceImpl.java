package com.drivers.router.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.entity.CadetPay;
import com.drivers.router.repository.CadetPayRepository;
import com.drivers.router.service.CadetPayService;
import com.drivers.router.web.request.CadetPayReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetPayResp;
import com.drivers.router.web.response.StatisticsCadetPayResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/8/13.
 */
@Service
@Transactional
public class CadetPayServiceImpl implements CadetPayService {

    @Autowired
    private CadetPayRepository cadetPayRepository;

    @Override
    public void save(Request<CadetPay> request, Response<Integer> response) {
        Integer result = cadetPayRepository.save(request.getContent());
        response.setContent(result);
    }

    @Override
    public void findOneByOpenId(Request<String> request, Response<CadetPayResp> response) {
        CadetPayResp CadetPayResp = cadetPayRepository.findByOpenId(request.getContent());
        response.setContent(CadetPayResp);
    }

    @Override
    public void findAllBySearch(final CadetPayReq request, PagerResponse<CadetPayResp> response){
        Long count = cadetPayRepository.countBySearch(request);
        List<CadetPayResp> cadetPayResps = cadetPayRepository.findAllBySearch(request);
        response.setTotal(count);
        response.setRows(cadetPayResps);
    }
    @Override
    public void statisticsAmount(final StatisticsReq request, PagerResponse<List<StatisticsCadetPayResp>> response){
        List<StatisticsCadetPayResp> result = cadetPayRepository.statisticsAmount(request);
        response.setContent(result);
    }

    @Override
    public void invalid(Request<Long> request, PagerResponse<Integer> response, String dataUpdater) {
        Integer result = cadetPayRepository.invalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void update(Request<CadetPay> request, Response<Integer> response) {
        CadetPay cadetPay = cadetPayRepository.findById(request.getContent().getId());
        CadetPay requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",cadetPay.getId());
        if (requestContent.getCadetId() != cadetPay.getCadetId()){
            map.put("cadetId",requestContent.getCadetId());
        }
        if (requestContent.getPayStatus() != cadetPay.getPayStatus()){
            map.put("payStatus",requestContent.getPayStatus());
        }
        if (requestContent.getPayAmount() != cadetPay.getPayAmount()){
            map.put("payAmount",requestContent.getPayAmount());
        }
        if (requestContent.getPayDatetime() != cadetPay.getPayDatetime()){
            map.put("payDatetime",requestContent.getPayDatetime());
        }
        if (requestContent.getDataUpdater() != cadetPay.getDataUpdater()){
            map.put("dataUpdater",requestContent.getDataUpdater());
        }
        cadetPayRepository.update(map);
    }
}
