package com.drivers.router.repository;

import com.drivers.entity.SysManager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysManagerRepository extends BaseRepository<SysManager,Long> {

    public List<SysManager> selectByPage(SysManager sysManager);
}