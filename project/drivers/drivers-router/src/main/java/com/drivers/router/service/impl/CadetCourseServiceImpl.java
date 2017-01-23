package com.drivers.router.service.impl;

import com.drivers.entity.CadetCourse;
import com.drivers.router.repository.CadetCourseRepository;
import com.drivers.router.service.CadetCourseService;
import com.drivers.router.web.request.CadetCourseReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetCourseResp;
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
public class CadetCourseServiceImpl implements CadetCourseService {

    @Autowired
    private CadetCourseRepository cadetCourseRepository;

    @Override
    public void save(Request<CadetCourse> request, Response<Integer> response) {
        Integer result = cadetCourseRepository.save(request.getContent());
        response.setContent(result);
    }

    @Override
    public void invalid(Request<Long> request, PagerResponse<Integer> response, String dataUpdater) {
        Integer result = cadetCourseRepository.invalid(request.getContent(),dataUpdater);
        response.setContent(result);
    }

    @Override
    public void update(Request<CadetCourse> request, Response<Integer> response) {
        CadetCourse cadetCourse = cadetCourseRepository.findById(request.getContent().getId());
        CadetCourse requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",cadetCourse.getId());
        if (requestContent.getCadetId() != cadetCourse.getCadetId()){
            map.put("cadetId",requestContent.getCadetId());
        }
        if (requestContent.getCourse() != cadetCourse.getCourse()){
            map.put("course",requestContent.getCourse());
        }
        if (requestContent.getDataUpdater() != cadetCourse.getDataUpdater()){
            map.put("dataUpdater",requestContent.getDataUpdater());
        }
        cadetCourseRepository.update(map);
    }

    @Override
    public void findAllBySearch(CadetCourseReq request, PagerResponse<CadetCourseResp> response) {
        Long count = cadetCourseRepository.countBySearch(request);
        List<CadetCourseResp> cadetCourseResps = cadetCourseRepository.findAllBySearch(request);
        response.setTotal(count);
        response.setRows(cadetCourseRepository.findAllBySearch(request)) ;
    }

    @Override
    public void findOneByOpenId(Request<String> request, Response<CadetCourseResp> response) {
        CadetCourseResp cadetCourseResp = cadetCourseRepository.findByOpenId(request.getContent());
        response.setContent(cadetCourseResp);
    }
}
