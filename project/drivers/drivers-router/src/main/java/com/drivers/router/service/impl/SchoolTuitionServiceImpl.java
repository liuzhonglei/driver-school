package com.drivers.router.service.impl;

import com.drivers.entity.School;
import com.drivers.entity.SchoolTuition;
import com.drivers.router.repository.SchoolRepository;
import com.drivers.router.service.SchoolTuitionService;
import com.drivers.router.repository.SchoolTuitionRepository;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.SchoolTuitionResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
@Service
@Transactional
public class SchoolTuitionServiceImpl implements SchoolTuitionService {
    @Autowired
    private SchoolTuitionRepository schoolTuitionRepository;

    @Transactional(readOnly = true)
    @Override
    public void findAllBySearch(Response<SchoolTuitionResp> response) {
        SchoolTuitionResp school = schoolTuitionRepository.findAllBySearch();
        response.setContent(school);
    }

    @Override
    public void updateSchoolTuition(Request<SingleFieldUpdateReq> request, Response<Integer> response) {
        Integer result = schoolTuitionRepository.updateSchoolTuition(request.getContent());
        response.setContent(result);
    }
}
