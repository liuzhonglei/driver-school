package com.drivers.manager.web.rest;

import com.drivers.entity.CadetCourse;
import com.drivers.entity.CadetPay;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.CadetCourseService;
import com.drivers.router.web.request.CadetCourseReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetCourseResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping("/api/cadetcourses")
public class CadetCourseResource extends BaseResource {
    @Autowired
    private CadetCourseService cadetCourseService;

    @RequestMapping(value = "/createOrUpdate",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createOrUpdate(@RequestBody @Validated Request<CadetCourse> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }

        if (request.getContent().getId() != null){
            request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
            cadetCourseService.update(request,response);
        }else {
            request.getContent().setDataCreator(SecurityUtils.getCurrentUserLogin());
            request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
            cadetCourseService.save(request,response);
        }

        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> deleteSysManager(@RequestBody @Validated Request<Long> request, BindingResult result) throws Exception{
        PagerResponse<Integer> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetCourseService.invalid(request,response, SecurityUtils.getCurrentUserLogin());
        return response;
    }

    @RequestMapping(value = "_search/cadetcourses", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<CadetCourseResp> getByPage(@Validated CadetCourseReq request, BindingResult result){
        PagerResponse<CadetCourseResp> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetCourseService.findAllBySearch(request,response);
        return response;
    }
}
