package com.drivers.router.service.impl;

import com.drivers.entity.Coach;
import com.drivers.entity.WxFans;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.service.CoachService;
import com.drivers.router.web.request.CoachReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.repository.CoachRepository;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.common.KeyValueResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/8/28.
 */
@Service
@Transactional
@Slf4j
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private WxFansRepository wxFansRepository;
    @Transactional(readOnly = true)
    @Override
    public void findAllBySearch(final CoachReq request, PagerResponse<Coach> response) {
        Long count = coachRepository.countBySearch(request);
        List<Coach> result = coachRepository.findAllBySearch(request);
        response.setTotal(count);
        response.setRows(result);
    }

    @Override
    public void findByCadetOpenId(Request<String> request, Response<Coach> response) {
        Coach coach = coachRepository.findByCadetOpenId(request.getContent());
        response.setContent(coach);
    }

    @Override
    public void save(Request<Coach> request, Response<Integer> response) {
        Integer result = coachRepository.save(request.getContent());
        response.setContent(result);
    }

    @Override
    public void invalid(Request<Long> request, PagerResponse<Integer> response,String dataUpdater) {
        Integer result = coachRepository.invalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void batchInvalid(Request<List<Long>> request, Response<Integer> response,String dataUpdater) {
        Integer result = coachRepository.batchInvalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response) {
        Integer result = coachRepository.siglnFieldUpdate(request.getContent());
        response.setContent(result);
    }

    @Override
    public void update(Request<Coach> request, Response<Integer> response) {
        Coach coach = coachRepository.findById(request.getContent().getId());
        Coach requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",coach.getId());
        if (requestContent.getName() != coach.getName()){
            map.put("name",requestContent.getName());
        }
        if (requestContent.getMobile() != coach.getMobile()){
            map.put("mobile",requestContent.getMobile());
        }
        if (requestContent.getMobile2() != coach.getMobile2()){
            map.put("mobile2",requestContent.getMobile2());
        }
        if (requestContent.getModel() != coach.getModel()){
            map.put("model",requestContent.getModel());
        }
        if (requestContent.getDataUpdater() != coach.getDataUpdater()){
            map.put("dataUpdater",requestContent.getDataUpdater());
        }
        coachRepository.update(map);
    }

    @Override
    public void getCoachDic(String name, Response<List<KeyValueResp>> response) {
        List<KeyValueResp> result = coachRepository.getCoachDic(name);
        response.setContent(result);
    }

    @Override
    public void bindWeixin(Request<Coach> request, Response<Integer> response) {
        Integer result = coachRepository.bindWeixin(request.getContent());
        wxFansRepository.bindByOpenid("coach",request.getContent().getId(),request.getContent().getWxOpenid());
        response.setContent(result);
    }

    @Override
    public void unbindWeixin(Request<Coach> request, Response<Integer> response) {
        Integer result = coachRepository.unbindWeixin(request.getContent().getId());
        wxFansRepository.unbindByOpenid(request.getContent().getWxOpenid());
        response.setContent(result);
    }
}
