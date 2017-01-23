package com.medal.framework.mybatis.base;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.SpecialProvider;

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

    public IstartProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String invalid(MappedStatement ms) {
        Class entityClass = this.getEntityClass(ms);
        String sql = "update " + this.tableName(entityClass) + " set data_status = 0" + SqlHelper.wherePKColumns(entityClass);
        System.out.println("sql = [" + sql + "]");
        return sql;
    }

    public String activate(MappedStatement ms){
        Class entityClass = this.getEntityClass(ms);
        String tableName = this.tableName(entityClass);
        return "update " + tableName + " set data_status = 1" + SqlHelper.wherePKColumns(entityClass);
    }
}
