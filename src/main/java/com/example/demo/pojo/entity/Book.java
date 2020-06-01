package com.example.demo.pojo.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    private Long id;
    private String sort;
    private String name;
    private String author;
    private long status;

    public Book() {
    }

    public Book(String sort, String name, String author) {
        this.sort = sort;
        this.name = name;
        this.author = author;
        this.status = 1;
    }

    public Book(Long id, String sort, String name, String author) {
        this.id = id;
        this.sort = sort;
        this.name = name;
        this.author = author;
    }

    public Book(String sort, String name, String author, long status) {
        this.sort = sort;
        this.name = name;
        this.author = author;
        this.status = status;
    }

    public Book(long id, String sort, String name, String author, long status) {

        this.id = id;
        this.sort = sort;
        this.name = name;
        this.author = author;
        this.status = status;
    }

}
