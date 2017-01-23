package com.drivers.manager.web.rest;

import com.drivers.entity.WxFans;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.WxFansService;
import com.drivers.router.web.request.WxFansReq;
import com.drivers.router.web.request.base.Request;
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

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xhuji on 2016/11/19.
 */
@RestController
@RequestMapping("/api/wxFans")
@Slf4j
public class WxFansResource extends BaseResource {

    @Autowired
    private WxFansService wxFansService;

    /**
     *
     * @param request
     * @param result
     * @return
     */
    @RequestMapping(value = "_search/wxFans", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<WxFansResp> getByPage(@Validated WxFansReq request, BindingResult result) throws Exception {
        PagerResponse<WxFansResp> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        wxFansService.findAllBySearch(request,response);
        return response;
    }

    @RequestMapping(value = "/getWxFansDic", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<KeyValueResp>> getWxFansDic(String name,String bindTable){
        Response<List<KeyValueResp>> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        wxFansService.getWxFansDic(name,bindTable,response);
        return response;
    }

    /**
     * 从微信公众号获取关注者 保持到本地数据库
     * @return
     */
    @RequestMapping(value = "/batchSaveWxFans", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> batchSaveWxFans() throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        wxFansService.batchSave(response);
        return response;
    }



}
