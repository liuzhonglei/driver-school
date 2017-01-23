package com.drivers.router.service;

import com.drivers.entity.Suggestion;
import com.drivers.router.web.request.SuggestionReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by xhuji on 2016/8/11.
 */
public interface SuggestionService {

    void save(Request<Suggestion> request, Response<Integer> response);

    void delete(Long id,Response<Integer> response);

    void invalid(Long id,Response<Integer> response);

    Suggestion findOne(Long id);

    List<Suggestion> findAll();

    Page<Suggestion> findAll(Pageable pageable);

    void findAllBySearch(final SuggestionReq request, PagerResponse<Suggestion> response);

    void closeSuggestion(Request<Suggestion> request, Response<Integer> response);
}
