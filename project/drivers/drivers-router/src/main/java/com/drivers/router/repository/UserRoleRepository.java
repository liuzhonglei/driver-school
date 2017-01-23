package com.drivers.router.repository;

import com.drivers.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleRepository extends BaseRepository<UserRole,Long> {
}