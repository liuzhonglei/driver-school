package com.drivers.router.repository;

import com.drivers.entity.Coach;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xhuji on 2016/9/8.
 */
@Mapper
public interface DriverRepository extends BaseRepository<Coach,Long> {
}
