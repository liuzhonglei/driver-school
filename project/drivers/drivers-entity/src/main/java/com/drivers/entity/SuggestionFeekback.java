package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "suggestion_feekback")
@Data
public class SuggestionFeekback {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 投诉建议数据ID
     */
    @Column(name = "suggestion_id")
    private Long suggestionId;
    /**
     * 操作类型(1:接受,2:拒绝,3:消息回复,4:关闭)
     */
    @Column(name = "op_type")
    private Integer opType;
    /**
     * 操作名称
     */
    @Column(name = "op_name")
    private String opName;
    /**
     * 反馈信息
     */
    private String content;
    /**
     * 数据创建者
     */
    @Column(name = "data_creator")
    private String dataCreator;

    /**
     * 数据更新者
     */
    @Column(name = "data_updater")
    private String dataUpdater;

    /**
     * 数据创建日期时间
     */
    @Column(name = "data_create_datetime")
    private ZonedDateTime dataCreateDatetime;

    /**
     * 数据更新日期时间
     */
    @Column(name = "data_update_datetime")
    private ZonedDateTime dataUpdateDatetime;
}