package com.drivers.manager.web.rest;

import com.drivers.entity.SchoolTuition;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.SchoolTuitionService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.SchoolTuitionResp;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping( value = "/api/schooltuitions")
public class SchoolTuitionResource extends BaseResource{

    @Autowired
    private SchoolTuitionService schoolTuitionService;

    @RequestMapping(value = "/singleFieldUpdate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> updateSchoolTuition(@RequestBody @Validated Request<SingleFieldUpdateReq> request, BindingResult result){
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        schoolTuitionService.updateSchoolTuition(request,response);
        return  response;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SchoolTuitionResp> getByPage(){
        Response<List<SchoolTuitionResp>> response = new Response<>();
        response.setStatusCode(StatusCode.OK);

        Response<SchoolTuitionResp> respResponse1 = new Response<>();
        schoolTuitionService.findAllBySearch(respResponse1);

        List<SchoolTuitionResp> list = new ArrayList<>();
        if (null != respResponse1.getContent()){
            list.add(respResponse1.getContent());
        }

        response.setContent(list);
        return response.getContent();
    }
}
