package com.drivers.manager.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.drivers.entity.School;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.request.SchoolReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RestController
@RequestMapping( value = "/api/schools")
public class SchoolResource extends BaseResource {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<School> getSchool(){
        Response<School> response = new Response<>();
        response.setStatusCode(StatusCode.OK);

        schoolService.findAll(response);
        return response;
    }


    @RequestMapping( value = "/update", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> updateSchool(@RequestBody @Validated Request<School> request, BindingResult result){
        Response<Integer> response = new Response<>();

        if (!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }

        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        schoolService.updateSchool(request,response);
        return response;
    }

    @Timed
    @Monitored
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("avatar")MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
    }
}
