package com.drivers.router.repository;

import com.drivers.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhuji on 2016/8/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@SpringApplicationConfiguration(SampleMybatis2Application.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CityRepositoryTest {
    @Autowired
    private CityRepository mapper;

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
        Assert.assertNotNull(city2.getName());
        Assert.assertNotNull(city2.getState());
    }

    @Test
    public void testSelectAll(){
        List<City> city2List = mapper.selectAll();
        for(City c2 : city2List){
            log.info(c2.toString());
            Assert.assertNotNull(c2);
            Assert.assertNotNull(c2.getName());
            Assert.assertNotNull(c2.getState());
        }
    }

}
