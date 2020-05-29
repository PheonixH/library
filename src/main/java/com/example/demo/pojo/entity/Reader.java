package com.example.demo.pojo.entity;

import java.io.Serializable;

public class Reader implements Serializable {

  private long id;
  private String name;
  private long grade;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getGrade() {
    return grade;
  }

  public void setGrade(long grade) {
    this.grade = grade;
  }

}
