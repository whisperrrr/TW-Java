package com.thoughtworks;

public class App {

  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant(" TW黄焖鸡 ");
    System.out.println("Welcome to" + restaurant.getName());

    System.out.println("我们的菜品有\n" + restaurant.showMenu());

    String result = restaurant.bestCharge("ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1");
    System.out.println(result);
  }
}
