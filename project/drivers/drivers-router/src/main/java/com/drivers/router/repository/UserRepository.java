package com.drivers.router.repository;

import com.drivers.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository extends BaseRepository<User,Long> {
}