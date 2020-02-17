package com.thoughtworks;

public class Restaurant {

  public static String bestCharge(String selectedItems) {
    Order order = new Order(selectedItems);
    return String.valueOf(order.renderOrder());
  }

}
