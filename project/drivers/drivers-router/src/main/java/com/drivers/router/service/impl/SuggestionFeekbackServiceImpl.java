package com.drivers.router.service.impl;

import com.drivers.entity.SuggestionFeekback;
import com.drivers.router.repository.SuggestionFeekbackRepository;
import com.drivers.router.repository.SuggestionRepository;
import com.drivers.router.service.SuggestionFeekbackService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/11/19.
 */
@Service
@Transactional
public class SuggestionFeekbackServiceImpl implements SuggestionFeekbackService {
    @Autowired
    private SuggestionFeekbackRepository suggestionFeekbackRepository;

    @Autowired
    private SuggestionRepository suggestionRepository;
    @Override
    public void createFeekback(Request<SuggestionFeekback> request, Response<Integer> response) {
        Integer result = suggestionFeekbackRepository.save(request.getContent());
        Integer result2 = suggestionRepository.updateBusinessStatusById(request.getContent().getSuggestionId(),2);
        response.setContent(result2);
    }

    @Override
    public void getFeekback(Request<SuggestionFeekback> request, Response<List<SuggestionFeekback>> response) {
        List<SuggestionFeekback> suggestionFeekbacks =  suggestionFeekbackRepository.findFeekbackBySuggestionId(request.getContent().getSuggestionId());
        response.setContent(suggestionFeekbacks);
    }
}
