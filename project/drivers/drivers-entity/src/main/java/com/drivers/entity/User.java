package com.drivers.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Table(name = "sys_manager")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private Boolean activated;

    @Column(name = "lang_key")
    private String langKey;

    @Column(name = "activation_key")
    private String activationKey;

    @Column(name = "reset_key")
    private String resetKey;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "reset_date")
    private Date resetDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}