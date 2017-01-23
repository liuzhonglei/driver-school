package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer seq;

    @Column(name = "create_datetime")
    private ZonedDateTime createDatetime;

    @Column(name = "update_datetime")
    private ZonedDateTime updateDatetime;

    @Column(name = "data_status")
    private Boolean dataStatus;

}