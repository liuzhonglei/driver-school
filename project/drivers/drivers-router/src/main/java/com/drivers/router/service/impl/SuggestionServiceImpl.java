package com.drivers.router.service.impl;

import com.drivers.entity.Suggestion;
import com.drivers.router.service.SuggestionService;
import com.drivers.router.web.request.SuggestionReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.repository.SuggestionRepository;
import com.drivers.router.web.response.base.Response;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/8/11.
 */
@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionRepository suggestionRepository;

    @Override
    public void save(Request<Suggestion> request, Response<Integer> response) {
        Suggestion suggestion = request.getContent();
        Integer id = suggestionRepository.save(suggestion);
        response.setContent(id);
    }

    @Override
    public void invalid(Long id,Response<Integer> response) {
        Integer result =  suggestionRepository.invalid(id);
        response.setContent(result);
    }

    @Override
    public void delete(Long id,Response<Integer> response) {

    }
    @Transactional(readOnly = true)
    @Override
    public Suggestion findOne(Long id) {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Suggestion> findAll() {
        return null;
    }
    @Transactional(readOnly = true)
    @Override
    public Page<Suggestion> findAll(Pageable pageable) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public void findAllBySearch(final SuggestionReq request, PagerResponse<Suggestion> response){
        List<Suggestion> suggestions = suggestionRepository.findAllBySearch(request);
        Long count = suggestionRepository.countBySearch(request);
        response.setTotal(count);
        response.setRows(suggestions);
    }

    @Override
    public void closeSuggestion(Request<Suggestion> request, Response<Integer> response) {
        Integer result = suggestionRepository.updateBusinessStatusById(request.getContent().getId(),3);
        response.setContent(result);
    }
}
