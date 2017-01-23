package com.drivers.router.repository;

import com.drivers.entity.Cadet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CadetRepository extends BaseRepository<Cadet,Long> {
}