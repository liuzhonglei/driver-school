package com.istart.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by xhuji on 2016/8/18.
 */
@Data
@NoArgsConstructor
public class City {

    private Integer id;

    private String cityName;

    private String cityState;

    public City(String cityName,String cityState){
        this.cityName = cityName;
        this.cityState = cityState;
    }
}
