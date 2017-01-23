package com.drivers.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/11/26.
 */
@Table(name = "token_history")
@Data
@ToString
public class TokenHistory {
    /**
     * 数据ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * token
     */
    @Column(name = "token")
    private String token;

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
