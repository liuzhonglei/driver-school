package com.istart.demo.service;

import com.github.pagehelper.PageHelper;
import com.istart.demo.entity.Suggestion;
import com.istart.demo.repository.SuggestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xhuji on 2016/8/17.
 */
@Service
public class SuggestionService {
    @Autowired
    private SuggestionMapper suggestionMapper;

    /**
     * 增或改
     * @param suggestion
     */
    public void save(Suggestion suggestion){
        if (suggestion.getId() != null){
            suggestionMapper.updateByPrimaryKey(suggestion);
        }else {
            suggestionMapper.insert(suggestion);
        }
    }

    /**
     * 删
     * @param id
     */
    public void deleteById(Long id){
        suggestionMapper.deleteByPrimaryKey(id);
    }

    public Suggestion getById(Long id){
        return suggestionMapper.selectByPrimaryKey(id);
    }

    public List<Suggestion> getAll(){
        PageHelper.startPage(0, 10, "id");
        return suggestionMapper.selectAll();
    }
}
