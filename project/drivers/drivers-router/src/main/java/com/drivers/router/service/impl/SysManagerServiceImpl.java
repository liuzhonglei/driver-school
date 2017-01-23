package com.drivers.router.service.impl;

import com.drivers.entity.SysManager;
import com.drivers.router.repository.SysManagerRepository;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.service.SysManagerService;
import com.drivers.router.web.request.SysManagerReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
@Service
@Transactional
@Slf4j
public class SysManagerServiceImpl implements SysManagerService {

    @Autowired
    private SysManagerRepository sysManagerRepository;
    @Autowired
    private WxFansRepository wxFansRepository;
    @Override
    public void save(Request<SysManager> request, Response<Integer> response){
        Integer result = sysManagerRepository.save(request.getContent());
        response.setContent(result);
    }

    @Transactional(readOnly = true)
    @Override
    public void findByPageSearch(final SysManagerReq request, PagerResponse<SysManager> response) {
        log.debug("Request to get search SysManager by Pageable");
        Long count = sysManagerRepository.countBySearch(request);
        List<SysManager> sysManagers = sysManagerRepository.findAllBySearch(request);

        response.setTotal(count);
        response.setRows(sysManagers);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean validateUsername(String username) {
        Integer result = sysManagerRepository.validateUsername(username);
        if(result == null || result==0){
            return true;
        }
        return false;
    }

    @Override
    public void bindWeixin(Request<SysManager> request, Response<Integer> response) {
        Integer result = sysManagerRepository.bindWeixin(request.getContent());
        wxFansRepository.bindByOpenid("sys_manager",request.getContent().getId(),request.getContent().getWxOpenid());
        response.setContent(result);
    }

    @Override
    public void unbindWeixin(Request<SysManager> request, Response<Integer> response) {
        Integer result = sysManagerRepository.unbindWeixin(request.getContent().getId());
        wxFansRepository.unbindByOpenid(request.getContent().getWxOpenid());
        response.setContent(result);
    }

    @Override
    public void updatePassword(Response<SysManager> request, Response<Integer> response) {
        Integer result = sysManagerRepository.updatePassword(request.getContent().getUsername(),request.getContent().getPassword());
        response.setContent(result);
    }

    @Override
    public void findByUsername(String username, Response<SysManager> response) {
        SysManager sysManager = sysManagerRepository.findByUsername(username);
        response.setContent(sysManager);
    }

    @Override
    public void invalid(Request<Long> request, PagerResponse<Integer> response,String dataUpdater) {
        Integer result = sysManagerRepository.invalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void batchInvalid(Request<List<Long>> request, Response<Integer> response,String dataUpdater) {
        Integer result = sysManagerRepository.batchInvalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response) {
        Integer result = sysManagerRepository.siglnFieldUpdate(request.getContent());
        response.setContent(result);
    }

    @Override
    public void update(Request<SysManager> request, Response<Integer> response) {
        SysManager sysManager = sysManagerRepository.findById(request.getContent().getId());
        SysManager requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",sysManager.getId());
        if (requestContent.getUsername() != sysManager.getUsername()){
            map.put("username",requestContent.getUsername());
        }
        if (requestContent.getPassword() != sysManager.getPassword()){
            map.put("password",sysManager.getPassword());
        }
        if (requestContent.getEmail() != sysManager.getEmail()){
            map.put("email",requestContent.getEmail());
        }
        if (requestContent.getAvatarUrl() != sysManager.getAvatarUrl()){
            map.put("avatarUrl",sysManager.getAvatarUrl());
        }
        if (requestContent.getName() != sysManager.getName()){
            map.put("name",requestContent.getName());
        }
        if (requestContent.getSex() != sysManager.getSex()){
            map.put("sex",requestContent.getSex());
        }
        if (requestContent.getBirthday() != sysManager.getBirthday()){
            map.put("birthday",requestContent.getBirthday());
        }
        if (requestContent.getMobile() != sysManager.getMobile()){
            map.put("mobile",requestContent.getMobile());
        }
        if (requestContent.getDataUpdater() != sysManager.getDataUpdater()){
            map.put("dataUpdater",requestContent.getDataUpdater());
        }
        sysManagerRepository.update(map);
    }
}
