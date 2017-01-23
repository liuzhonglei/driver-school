package com.drivers.router.service.impl;

import com.drivers.entity.School;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.repository.SchoolRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.iterators.ObjectArrayIterator;
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
 * @version 1.0 2016/8/12
 */
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Transactional(readOnly = true)
    @Override
    public void findAll(Response<School> response) {
        List<School> schools = schoolRepository.findAll();
        if (CollectionUtils.isEmpty(schools)){
            response.setContent(new School());
        }
        response.setContent(schools.get(0));
    }

    @Override
    public void updateSchool(Request<School> request, Response<Integer> response) {
//        School school = schoolRepository.findById(request.getContent().getId());
        School requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",requestContent.getId());
        map.put("name",requestContent.getName());
        map.put("mobile",requestContent.getMobile());
        map.put("phone",requestContent.getPhone());
        map.put("email",requestContent.getEmail());
        map.put("addr",requestContent.getAddr());
        map.put("slogan",requestContent.getSlogan());
        map.put("introduction",requestContent.getIntroduction());
        map.put("administrators",requestContent.getAdministrators());
        map.put("data_updater",requestContent.getDataUpdater());
        schoolRepository.update(map);
    }
}
