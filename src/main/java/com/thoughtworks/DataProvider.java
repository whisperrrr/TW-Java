package com.thoughtworks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

  public static List<Dish> getDishes() {
    return Arrays.asList(
        new Dish("ITEM0001", "黄焖鸡", 18.00),
        new Dish("ITEM0013", "肉夹馍", 6.00),
        new Dish("ITEM0022", "凉皮", 8.00),
        new Dish("ITEM0030", "冰粉", 2.00));
  }

  public static List<String> getHalfDishIds() {
    return Arrays.asList("ITEM0001", "ITEM0022");
  }
  //转成哈希表的格式，通过id查找
  public static Map<String, Dish> getHashDishes() {
    Map<String, Dish> hashDishes = new HashMap<>();
    List<Dish> dishes = getDishes();
    for (Dish dish: dishes) {
      String id = dish.getId();
      dish.setHalf(isHalf(id));
      hashDishes.put(id, dish);
    }
    return hashDishes;
  }
  //商品是否为半价
  public static boolean isHalf(String id) {
    List<String> halfDishes = getHalfDishIds();
    return halfDishes.contains(id);
  }
}
