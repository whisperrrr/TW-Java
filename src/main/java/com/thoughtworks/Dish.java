package com.thoughtworks;

public class Dish {

  private String id;
  private String name;
  private double price;
  private int num;
  private boolean half;

  public Dish(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public boolean isHalf() {
    return half;
  }

  public void setHalf(boolean half) {
    this.half = half;
  }
}
