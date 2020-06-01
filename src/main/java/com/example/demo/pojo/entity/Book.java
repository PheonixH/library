package com.example.demo.pojo.entity;


import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    private long id;
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

    public Book(long id, String sort, String name, String author) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

}
