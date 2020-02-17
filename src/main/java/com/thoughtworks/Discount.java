package com.thoughtworks;

import java.util.ArrayList;

/*
* 折扣类：
* 1.算折扣金额
* 2.返回折扣字符串
* */
public abstract class Discount {
   public abstract double getDiscount(ArrayList<Dish> orderList);
   public abstract StringBuilder getDiscountStr(ArrayList<Dish> orderList);
}
