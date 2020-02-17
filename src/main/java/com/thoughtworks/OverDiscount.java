package com.thoughtworks;

import java.util.ArrayList;

public class OverDiscount extends Discount {
    @Override
    public double getDiscount(ArrayList<Dish> orderList) {

        double cost = 0;
        for(Dish dish:orderList) {
                cost += dish.getPrice() * dish.getNum();
        }
        return cost > 30? (cost - 6):cost;
    }

    @Override
    public StringBuilder getDiscountStr(ArrayList<Dish> orderList) {

        StringBuilder str = new StringBuilder();
        str.append("使用优惠:\n").append("满30减6元，省6元\n");
        str.append("-----------------------------------\n");

        str.append("总计：").append((int)getDiscount(orderList)).append("元\n");
        str.append("===================================");
        return str;
    }
}
