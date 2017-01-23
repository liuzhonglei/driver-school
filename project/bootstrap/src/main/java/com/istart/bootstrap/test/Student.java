package com.istart.bootstrap.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by xhuji on 2016/8/28.
 */
@Data
public class Student {
    @JsonProperty("name")
    String name;
    @JsonProperty("student.age")
    String age;
}
