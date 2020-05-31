package com.example.demo.pojo.entity;

import java.io.Serializable;

public class Books implements Serializable {

    private String sort;
    private String name;
    private String author;
    private long sum;
    private long exists;

    public Books(String sort, String name, String author, long sum, long exists) {
        this.sort = sort;
        this.name = name;
        this.author = author;
        this.sum = sum;
        this.exists = exists;
    }

    public Books() {
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


    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }


    public long getExists() {
        return exists;
    }

    public void setExists(long exists) {
        this.exists = exists;
    }

}
