package com.thoughtworks;

import java.util.ArrayList;
import java.util.Map;

import static com.thoughtworks.DataProvider.getHashDishes;

public class Order {
    private String orderStr;

    public Order(String orderStr) {
        this.orderStr = orderStr;
    }

    /*
    * 解析输入
    * 输入：ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1
    * 输出：ArrayList<Dish>：包括id,名称,价格，是否半价,数量
    * */
    public ArrayList<Dish> parseOrder() {
        String[] itemList = orderStr.split(",");
        ArrayList<Dish> orderList = new ArrayList<>();
        Map<String, Dish> dishList = getHashDishes();

        for (String item:itemList) {
            String[] itemInfo = item.split(" x ");
            String id = itemInfo[0];
            int num = Integer.parseInt(itemInfo[1]);

            Dish dish = dishList.get(id);
            dish.setNum(num);

            orderList.add(dish);
        }
        return orderList;
    }

    /*
    * 输出订单
    * */
    public StringBuilder renderOrder() {
        ArrayList<Dish> orderList = parseOrder();
        StringBuilder billStr = new StringBuilder();
        billStr.append("============= 订餐明细 =============\n");
        billStr.append(getbillDetailStr());
        billStr.append(chooseDiscount().getDiscountStr(orderList));
        return billStr;
    }

    public StringBuilder getbillDetailStr() {
        ArrayList<Dish> orderList = parseOrder();
        StringBuilder billDetailStr = new StringBuilder();
        for (Dish dish:orderList) {
            billDetailStr.append(dish.getName()).append(" x ").append(dish.getNum());
            billDetailStr.append(" = ").append((int)(dish.getNum() * dish.getPrice())).append("元\n");
        }
        billDetailStr.append("-----------------------------------\n");
        return billDetailStr;
    }

    public Discount chooseDiscount() {
        ArrayList<Dish> orderList = parseOrder();
        Discount halfDiscount = new HalfDiscount();
        Discount overDiscount = new OverDiscount();
        Discount noDiscount = new NoDiscount();

        double halfCost = halfDiscount.getDiscount(orderList);
        double overCost = overDiscount.getDiscount(orderList);
        double noCost = noDiscount.getDiscount(orderList);

        if (overCost == noCost && halfCost == noCost) {
            return noDiscount;
        } else if (overCost <= halfCost) {
            return overDiscount;
        } else {
            return halfDiscount;
        }
    }
}
