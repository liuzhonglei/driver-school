package com.drivers.router.repository;

import com.drivers.entity.PersistentLogins;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersistentLoginsRepository extends BaseRepository<PersistentLogins,Long> {
}