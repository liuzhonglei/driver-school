package com.drivers.entity;

import lombok.Data;

import javax.persistence.*;
@Table(name = "city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String state;

    public City(){}

    public City(String name,String state){
        this.name = name;
        this.state = state;
    }
}