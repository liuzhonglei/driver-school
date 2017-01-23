package com.drivers.router.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.service.CadetService;
import com.drivers.router.web.request.CadetReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.CadetResp;
import com.drivers.router.web.response.StatisticsCadetNumResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.repository.CadetRepository;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional
@Slf4j
public class CadetServiceImpl implements CadetService{
    @Autowired
    private CadetRepository cadetRepository;
    @Autowired
    private WxFansRepository wxFansRepository;
    @Override
    public void save(final Request<Cadet> request, Response<Long> response) {
        Long result = cadetRepository.save(request.getContent());
        response.setContent(result);
    }

    @Override
    public void batchSave(Request<List<Cadet>> request, Response<Integer> response) {
        Integer result = cadetRepository.batchSave(request.getContent());
        response.setContent(result);
    }

    @Transactional(readOnly = true)
    @Override
    public void findAllBySearch(final CadetReq request, PagerResponse<CadetResp> response) {
        Long count = cadetRepository.countBySearch(request);
        List<CadetResp> cadetResps = cadetRepository.findAllBySearch(request);

        response.setTotal(count);
        response.setRows(cadetResps);
    }
    @Transactional(readOnly = true)
    @Override
    public void statisticsCadetNum(StatisticsReq request, PagerResponse<List<StatisticsCadetNumResp>> response) {
        List<StatisticsCadetNumResp> result = cadetRepository.statisticsCadetNum(request);
        response.setContent(result);
    }
    @Override
    public void invalid(Request<Long> request, PagerResponse<Integer> response,String dataUpdater) {
        Integer result = cadetRepository.invalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void batchInvalid(Request<List<Long>> request, Response<Integer> response,String dataUpdater) {
        Integer result = cadetRepository.batchInvalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response) {
        Integer result = cadetRepository.siglnFieldUpdate(request.getContent());
        response.setContent(result);
    }

    @Override
    public void bindWeixin(Request<Cadet> request, Response<Integer> response) {
        Integer result = cadetRepository.bindWeixin(request.getContent());
        wxFansRepository.bindByOpenid("cadet",request.getContent().getId(),request.getContent().getWxOpenid());
        response.setContent(result);
    }

    @Override
    public void relateCoach(Request<Cadet> request, Response<Integer> response) {
        Integer result = cadetRepository.relateCoach(request.getContent());
        wxFansRepository.unbindByOpenid(request.getContent().getWxOpenid());
        response.setContent(result);
    }

    @Override
    public void unbindWeixin(Request<Cadet> request, Response<Integer> response) {
        Integer result = cadetRepository.unbindWeixin(request.getContent().getId());
        wxFansRepository.unbindByOpenid(request.getContent().getWxOpenid());
        response.setContent(result);
    }
}
