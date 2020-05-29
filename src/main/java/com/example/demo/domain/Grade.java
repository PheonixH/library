package com.example.demo.domain;

import java.io.Serializable;

public class Grade implements Serializable {

  private long id;
  private long max;

  public Grade(long id, long max) {
    this.id = id;
    this.max = max;
  }

  public Grade() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMax() {
    return max;
  }

  public void setMax(long max) {
    this.max = max;
  }

}
