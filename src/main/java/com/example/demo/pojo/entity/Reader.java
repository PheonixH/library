package com.example.demo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements Serializable {

    private Long id;
    private String name;
    private String password;
    private long grade;

}
