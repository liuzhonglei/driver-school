package com.drivers.router.service;

import com.drivers.entity.SuggestionFeekback;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;

import java.util.List;

/**
 * Created by xhuji on 2016/11/19.
 */
public interface SuggestionFeekbackService {

    void createFeekback(final Request<SuggestionFeekback> request, Response<Integer> response);

    void getFeekback(Request<SuggestionFeekback> request, Response<List<SuggestionFeekback>> response);
}
