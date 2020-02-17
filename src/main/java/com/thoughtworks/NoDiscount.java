package com.thoughtworks;

import java.util.ArrayList;

public class NoDiscount extends Discount {
    @Override
    public double getDiscount(ArrayList<Dish> orderList) {

        double cost = 0;
        for(Dish dish:orderList) {
                cost += dish.getPrice() * dish.getNum();
        }
        return cost;
    }

    @Override
    public StringBuilder getDiscountStr(ArrayList<Dish> orderList) {
        StringBuilder str = new StringBuilder();
        str.append("总计：").append((int)getDiscount(orderList)).append("元\n");
        str.append("===================================");
        return str;
    }
}
