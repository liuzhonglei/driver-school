package com.istart.bootstrap.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xhuji on 2016/8/28.
 */
@Data
public class Request implements Serializable{
    @JsonProperty("message")
    String message;
    @JsonProperty("student")
    Student student;
}
