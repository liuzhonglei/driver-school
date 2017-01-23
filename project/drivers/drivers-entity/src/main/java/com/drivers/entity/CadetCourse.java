package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cadet_course")
@Data
public class CadetCourse {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学员信息数据ID
     */
    @Column(name = "cadet_id")
    private Long cadetId;

    /**
     * 目前课程
     */
    private Integer course;

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