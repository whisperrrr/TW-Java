package com.thoughtworks;

import java.util.ArrayList;

public class HalfDiscount extends Discount {

    @Override
    public double getDiscount(ArrayList<Dish> orderList) {
        double cost = 0;
        for(Dish dish:orderList) {
           if(dish.isHalf()) {
               cost += dish.getPrice() * dish.getNum() * 0.5;
           } else {
               cost += dish.getPrice() * dish.getNum();
           }
        }
        return cost;
    }

    @Override
    public StringBuilder getDiscountStr(ArrayList<Dish> orderList) {
        double discount = 0;
        ArrayList<String> halfItem = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for(Dish dish:orderList) {
            if(dish.isHalf()) {
                discount += dish.getPrice() * dish.getNum() * 0.5;
                halfItem.add(dish.getName());
            }
        }

        str.append("使用优惠:\n");
        str.append("指定菜品半价(").append(String.join("，",halfItem)).append(")，");
        str.append("省").append((int)discount).append("元\n");
        str.append("-----------------------------------\n");

        str.append("总计：").append((int)getDiscount(orderList)).append("元\n");
        str.append("===================================");
        return str;
    }
}
