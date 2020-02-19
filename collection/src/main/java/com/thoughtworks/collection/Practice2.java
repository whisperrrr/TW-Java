package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice2 {

    public static void main(String[] args) {
        //分别用for循环、增强for循环、迭代器遍历并打印getNumbers返回的List
        List<Integer> list = getNumbers();
        //1.for循环遍历打印
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            System.out.println(temp);
        }
        System.out.println("================================");

        //2.增强for循环遍历打印
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("================================");

        //3.迭代器遍历打印
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    /**
     * 创建一个List 然后在List中添加0到100整数
     */
    public static List<Integer> getNumbers() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        return list;
    }


}
