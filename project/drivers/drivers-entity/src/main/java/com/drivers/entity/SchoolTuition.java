package com.drivers.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "school_tuition")
@Data
public class SchoolTuition {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 驾校信息数据ID
     */
    @Column(name = "school_id")
    private Long schoolId;

    /**
     * 学费
     */
    private Integer tuition;

    /**
     * 学费说明
     */
    @Column(name = "tuition_explain")
    private String tuitionExplain;

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