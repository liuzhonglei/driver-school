package com.drivers.router.repository;

import com.drivers.entity.CadetPay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CadetPayRepository extends BaseRepository<CadetPay,Long> {
}