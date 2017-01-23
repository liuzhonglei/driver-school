package com.drivers.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "persistent_logins")
@Data
public class PersistentLogins {
    @Id
    private String series;

    private String username;

    private String token;

    @Column(name = "last_used")
    private ZonedDateTime lastUsed;

}