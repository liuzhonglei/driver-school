package com.istart.demo.repository;

import com.istart.demo.entity.Suggestion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xhuji on 2016/8/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SuggestionRepositoryTest {

    @Autowired
    private SuggestionRepository suggestionRepository;

    /**
     * 测试Spring 注解方式
     */
    @Test
    public void testFindOne(){
        suggestionRepository.findOne(1L);
    }

    /**
     * 测试xml方式
     */
    @Test
    public void test(){
        suggestionRepository.selectSuggestionAndFeekback(1L);
    }
    /**
     * 测试通用Mapper
     */
    @Test
    public void test3(){
        suggestionRepository.selectAll();
    }
    /**
     * 测试封装的BaseMapper
     */
    @Test
    public void test2(){
        suggestionRepository.activate(1L);
    }
    @Test
    public void testss(){
        suggestionRepository.selectCount(new Suggestion());
    }
}
