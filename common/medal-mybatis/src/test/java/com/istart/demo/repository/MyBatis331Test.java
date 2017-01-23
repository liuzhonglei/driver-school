package com.istart.demo.repository;

import com.medal.SampleMybatisApplication;
import com.istart.demo.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(SampleMybatisApplication.class)
@Slf4j
public class MyBatis331Test {
    @Autowired
    private MyBatis331Mapper mapper;

    @Test
    @Rollback
    public void testInsertList() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("石家庄", "河北"));
        cityList.add(new City("邯郸", "河北"));
        cityList.add(new City("秦皇岛", "河北"));
        Assert.assertEquals((Object)3, mapper.insertCities(cityList));
        for (City c2 : cityList) {
            log.info(c2.toString());
            Assert.assertNotNull(c2.getId());
        }
    }

    @Test
    public void testSelectById(){
        City city2 = mapper.selectByCityId(1);
        log.info(city2.toString());
        Assert.assertNotNull(city2);
        Assert.assertNotNull(city2.getCityName());
        Assert.assertNotNull(city2.getCityState());
    }

    @Test
    public void testSelectAll(){
        List<City> city2List = mapper.selectAll();
        for(City c2 : city2List){
            log.info(c2.toString());
            Assert.assertNotNull(c2);
            Assert.assertNotNull(c2.getCityName());
            Assert.assertNotNull(c2.getCityState());
        }
    }

}
