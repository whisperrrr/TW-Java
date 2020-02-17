package com.thoughtworks;

import java.util.List;

import static com.thoughtworks.DataProvider.getDishes;

public class Restaurant {
  private String name;

  public Restaurant() {
  }

  public Restaurant(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static String bestCharge(String selectedItems) {
    Order order = new Order(selectedItems);
    return String.valueOf(order.renderOrder());
  }

  public static String showMenu() {
    List<Dish> dishes = getDishes();
    StringBuilder Menu = new StringBuilder();

    for (Dish dish:dishes) {
      Menu.append("ID: ").append(dish.getId()).append(" ");
      Menu.append("商品: ").append(dish.getName()).append(" ");
      Menu.append("价格: ").append(dish.getPrice()).append('\n');
    }

    return String.valueOf(Menu);
  }
}
