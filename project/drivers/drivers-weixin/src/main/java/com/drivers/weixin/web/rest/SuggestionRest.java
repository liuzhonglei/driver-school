package com.drivers.weixin.web.rest;

import com.drivers.entity.Suggestion;
import com.drivers.router.service.SuggestionService;
import com.drivers.router.web.request.base.Request;
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
 * Created by xhuji on 2016/10/30.
 */
@RestController
@RequestMapping(value = "/api/suggestions")
public class SuggestionRest extends BaseResource {

    @Autowired
    private SuggestionService suggestionService;

    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createSuggestion(@RequestBody @Validated Request<Suggestion> request, BindingResult result)throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        suggestionService.save(request,response);
        return response;
    }
}
