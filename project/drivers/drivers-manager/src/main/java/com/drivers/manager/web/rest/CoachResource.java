package com.drivers.manager.web.rest;

import com.drivers.entity.Coach;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.CoachService;
import com.drivers.router.web.request.CoachReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
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
 * Created by xhuji on 2016/8/28.
 */
@RestController
@RequestMapping(value = "/api/coachs")
@Slf4j
public class CoachResource extends BaseResource {

    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "/create", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createCoach(@RequestBody @Validated Request<Coach> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }

        if (request.getContent().getId() != null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能有值");
            return response;
        }
        request.getContent().setDataCreator(SecurityUtils.getCurrentUserLogin());
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        coachService.save(request,response);
        return response;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> deleteCoach(@RequestBody @Validated Request<Long> request, BindingResult result) throws Exception{
        PagerResponse<Integer> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        coachService.invalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }

    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> batchDeleteCoach(@RequestBody @Validated Request<List<Long>> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        coachService.batchInvalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> update(@RequestBody @Validated Request<Coach> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        coachService.update(request,response);
        return response;
    }

    /**
     * 单个字段更新
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/singleFieldUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> singleFieldUpdate(@RequestBody @Validated Request<SingleFieldUpdateReq> request, BindingResult result ) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        coachService.siglnFieldUpdate(request,response);
        return response;
    }

    @RequestMapping(value = "/_search/coachs", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<Coach> getByPage(@Validated CoachReq request, BindingResult result){
        PagerResponse<Coach> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        coachService.findAllBySearch(request,response);
        return response;
    }

    @RequestMapping(value = "/getCoachDic", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<KeyValueResp>> getCoachDic(String name){
        Response<List<KeyValueResp>> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        coachService.getCoachDic(name,response);
        return response;
    }

    /**
     * 绑定微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> bindWeixin(@RequestBody @Validated Request<Coach> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        coachService.bindWeixin(request,response);
        return response;
    }
    /**
     * 解绑微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unbindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> unbindWeixin(@RequestBody @Validated Request<Coach> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        coachService.unbindWeixin(request,response);
        return response;
    }
}
