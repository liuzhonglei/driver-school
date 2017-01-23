package com.medal.tool.wiki.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by xhuji on 2016/8/31.
 */
@Data
@Table(name = "column",schema = "information_schema")
public class TableWiki {

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "column_type")
    private String columnType;

    @Column(name = "column_comment")
    private String columnComment;

    @Column(name = "column_default")
    private String columnDefault;

    @Column(name = "is_nullable")
    private String isNullable;

    @Column(name = "table_schema")
    private String tableSchema;

    @Column(name = "table_name")
    private String tableName;
}
