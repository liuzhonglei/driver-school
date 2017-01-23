package com.drivers.manager.web.rest;

import com.drivers.entity.School;
import com.drivers.entity.WxMerchant;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.WxFansService;
import com.drivers.router.service.WxMerchantService;
import com.drivers.router.web.request.CadetReq;
import com.drivers.router.web.request.WxFansReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetResp;
import com.drivers.router.web.response.WxFansResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.response.common.KeyValueResp;
import com.drivers.router.web.rest.base.BaseResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xhuji on 2016/11/13.
 */
@RestController
@RequestMapping("/api/wxInfo")
@Slf4j
public class WxInfoResource extends BaseResource{
    @Autowired
    private WxMerchantService wxMerchantService;

    @RequestMapping(value = "/get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<WxMerchant> getSchool(){
        Response<WxMerchant> response = new Response<>();
        response.setStatusCode(StatusCode.OK);

        wxMerchantService.findAll(response);
        return response;
    }

    @RequestMapping( value = "/update", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> updateSchool(@RequestBody @Validated Request<WxMerchant> request, BindingResult result){
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
        wxMerchantService.updateWxMerchant(request,response);
        return response;
    }

}
