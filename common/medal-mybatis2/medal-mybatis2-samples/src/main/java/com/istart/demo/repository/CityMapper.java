package com.istart.demo.repository;

import com.istart.demo.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xhuji on 2016/8/18.
 */
@Mapper
public interface CityMapper {
    /**
     * 批量插入
     *
     * @param cities
     * @return
     */
    @Insert(
        "<script>" +
            "insert into city (id,name,state) values" +
            "<foreach collection=\"list\" item=\"city\" separator=\",\">" +
                "(#{city.id},#{city.cityName},#{city.cityState})" +
            "</foreach>" +
         "</script>"
    )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertCities(List<City> cities);

    /**
     * 根据主键查询一个
     *
     * @param id
     * @return
     */
    @Results(id = "cityResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "cityName", column = "name", id = true),
            @Result(property = "cityState", column = "state", id = true)
    })
    @Select("select id, name, state from city where id = #{id}")
    City selectByCityId(Integer id);

    /**
     * 查询全部，引用上面的Results
     *
     * @return
     */
    @ResultMap("cityResult")
    @Select("select id, name, state from city")
    List<City> selectAll();
}
