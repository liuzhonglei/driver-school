package com.medal.framework.mybatis.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/17
 */
public class IstartProvider extends MapperTemplate {
    public static  final Logger log = LoggerFactory.getLogger(IstartProvider.class);
    public IstartProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String invalid(MappedStatement ms) {
        Class entityClass = this.getEntityClass(ms);
        String sql = "update " + this.tableName(entityClass) + " set data_status = 0" + SqlHelper.wherePKColumns(entityClass);
        log.debug("IstartProvider-invalid:{}",sql);
        return sql;
    }

    public String activate(MappedStatement ms){
        Class entityClass = this.getEntityClass(ms);
        String tableName = this.tableName(entityClass);
        String sql = "update " + tableName + " set data_status = 1" + SqlHelper.wherePKColumns(entityClass);
        log.debug("IstartProvider-activate:{}",sql);
        return sql;
    }
}
