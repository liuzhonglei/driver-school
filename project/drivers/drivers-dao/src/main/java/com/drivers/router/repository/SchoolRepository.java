package com.drivers.router.repository;

import com.drivers.entity.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolRepository extends BaseRepository<School,Long> {

    @Select("select * from school")
    public List<School> findAll();
}