package com.example.demo.pojo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Reader implements Serializable {

    private Long id;
    private String name;
    private String password;
    private long grade;

}
