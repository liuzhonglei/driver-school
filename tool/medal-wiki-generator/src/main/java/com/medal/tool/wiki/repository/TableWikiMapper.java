package com.medal.tool.wiki.repository;

import com.medal.framework.mybatis.base.BaseMapper;
import com.medal.tool.wiki.entity.TableWiki;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xhuji on 2016/9/1.
 */
@Mapper
public interface TableWikiMapper extends BaseMapper<TableWiki> {
//    @Select("select t.COLUMN_NAME,t.COLUMN_TYPE,t.COLUMN_COMMENT,t.COLUMN_DEFAULT,t.IS_NULLABLE,t.TABLE_SCHEMA, t.TABLE_NAME " +
//            "from information_schema.`COLUMNS` t " +
//            "where t.TABLE_SCHEMA = #{tableSchema} " +
//            "and t.TABLE_NAME = #{tableName} " +
//            "order by t.COLUMN_NAME;")
//    public List<TableWiki> findTableWikiByTableName(@Param("tableName")String tableName, @Param("tableSchema")String tableSchema);

    @Results(id = "cityResult", value = {
            @Result(property = "columnName", column = "column_name", id = true),
            @Result(property = "columnType", column = "column_type", id = true),
            @Result(property = "columnComment", column = "column_comment", id = true),
            @Result(property = "columnDefault", column = "column_default", id = true),
            @Result(property = "isNullable", column = "is_nullable", id = true),
            @Result(property = "tableSchema", column = "table_schema", id = true),
            @Result(property = "tableName", column = "table_name", id = true)
    })
    @Select("select column_name,column_type,column_comment,column_default,is_nullable,table_schema, table_name " +
            "from information_schema.columns " +
            "where table_schema = #{tableSchema} " +
            "and table_name = #{tableName} " +
            "order by column_name")
    public List<TableWiki> findTableWikiByTableName(@Param("tableName") String tableName, @Param("tableSchema")String tableSchema);
}
