package com.drivers.router.repository;

import com.drivers.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolRepository extends BaseRepository<School,Long> {

    @Select("select * from school")
    List<School> findAll();

    Integer update(Map<String,Object> map);

    @Select("select * from school where id = #{id}")
    School findById(Long id);
}