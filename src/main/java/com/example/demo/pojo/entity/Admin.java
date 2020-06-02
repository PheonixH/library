package com.example.demo.pojo.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
