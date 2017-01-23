package com.drivers.router.repository;

import com.drivers.entity.CadetCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CadetCourseRepository extends BaseRepository<CadetCourse,Long> {

}