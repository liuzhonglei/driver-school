package com.drivers.manager.web.rest;

import com.drivers.entity.Suggestion;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.SuggestionService;
import com.drivers.router.web.request.SuggestionReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.rest.base.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping(value = "/api/suggestions")
public class SuggestionResource extends BaseResource {
    @Autowired
    private SuggestionService suggestionService;

    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createSuggestion(@RequestBody @Validated Request<Suggestion> request,BindingResult result){
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        suggestionService.save(request,response);
        return response;
    }

    @RequestMapping(value = "/invalid/{id}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> deleteSuggestion(@PathVariable Long id){
        Response<Integer> response = new Response<>();
        suggestionService.invalid(id,response);
        return response;
    }

    @RequestMapping(value = "/close",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> closeSuggestion(@RequestBody @Validated Request<Suggestion> request, BindingResult result){
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
        suggestionService.closeSuggestion(request,response);
        return response;
    }

    @RequestMapping(value = "/_search/suggestions", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<Suggestion> getByPage(@Validated SuggestionReq request, BindingResult result){
        PagerResponse<Suggestion> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        //请求内容处理
        if(request.getStartTime() == null){
            request.setStartTime(LocalDate.parse("2000-01-01"));
        }
        if (request.getEndTime()== null){
            request.setEndTime(LocalDate.now());
        }else {
            request.setEndTime(LocalDate.now().plusDays(1));
        }
        suggestionService.findAllBySearch(request,response);
        return response;
    }
}
