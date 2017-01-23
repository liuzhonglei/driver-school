package com.drivers.router.repository;

import com.drivers.entity.SchoolTuition;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchoolTuitionRepository extends BaseRepository<SchoolTuition,Long> {
}