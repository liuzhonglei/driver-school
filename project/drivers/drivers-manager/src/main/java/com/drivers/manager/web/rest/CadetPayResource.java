package com.drivers.manager.web.rest;

import com.drivers.entity.CadetPay;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.CadetPayService;
import com.drivers.router.web.request.CadetPayReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetPayResp;
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
@RequestMapping("/api/cadetpays")
public class CadetPayResource extends BaseResource {
    @Autowired
    private CadetPayService cadetPayService;

    @RequestMapping(value = "/createOrUpdate",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createOrUpdate(@RequestBody @Validated Request<CadetPay> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }

        if (request.getContent().getId() != null){
            request.getContent().setPayStatus(1);
            request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
            cadetPayService.update(request,response);
        }else {
            request.getContent().setPayStatus(1);
            request.getContent().setDataCreator(SecurityUtils.getCurrentUserLogin());
            request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
            cadetPayService.save(request,response);
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
        cadetPayService.invalid(request,response, SecurityUtils.getCurrentUserLogin());
        return response;
    }

    /**
     *
     * @param request
     * @param result
     * @return
     */
    @RequestMapping(value = "_search/cadetpays", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<CadetPayResp> getByPage(@Validated CadetPayReq request, BindingResult result){
        PagerResponse<CadetPayResp> response = new PagerResponse<CadetPayResp>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        cadetPayService.findAllBySearch(request,response);
        return response;
    }
}
