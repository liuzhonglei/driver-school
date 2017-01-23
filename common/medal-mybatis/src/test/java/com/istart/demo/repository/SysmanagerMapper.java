package com.istart.demo.repository;

import com.istart.demo.entity.Sysmanager;
import com.medal.framework.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/16
 */
@Mapper
public interface SysmanagerMapper extends BaseMapper<Sysmanager> {
    @Select("select * from sys_manager where id = #{id}")
    Sysmanager findById(@Param("id") Long id);
}
