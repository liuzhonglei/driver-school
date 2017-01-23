package com.drivers.manager.web.rest;

import com.drivers.entity.Cadet;
import com.drivers.entity.SuggestionFeekback;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.SuggestionFeekbackService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
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
 * Created by xhuji on 2016/11/19.
 */
@RestController
@RequestMapping("/api/feekbacks")
@Slf4j
public class SuggestionFeekbackResource extends BaseResource {
    @Autowired
    private SuggestionFeekbackService suggestionFeekbackService;

    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createFeekback(@RequestBody @Validated Request<SuggestionFeekback> request, BindingResult result) throws Exception{
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
        suggestionFeekbackService.createFeekback(request,response);
        return response;
    }

    @RequestMapping(value = "/getFeekback", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SuggestionFeekback> getFeekback(@RequestBody @Validated Request<SuggestionFeekback> request, BindingResult result) throws Exception{
        Response<List<SuggestionFeekback>> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        suggestionFeekbackService.getFeekback(request,response);
        return response.getContent();
    }
}
