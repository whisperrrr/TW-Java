package com.thoughtworks;
/*
* 自动抽牌机
* */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CardMachine {
    // 抽牌并显示
    public static void drawCard() {
        int num = getNum();
        ArrayList<Card> cards = getCardsRandom(num);

    }
    // 获取正确输入
    public static int getNum() {
        while(true) {
            System.out.println("请输入抽取的张数(小于等于52)：");

            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            if (num <= Card.getCardNum()) {
                return num;
            }

            System.out.println("您的输入有误哦");
        }
    }
    // 随机抽取n张牌并显示
    public static ArrayList<Card> getCardsRandom(int n) {
        ArrayList<Card> cards = Card.getCards();
        ArrayList<Card> newCards = new ArrayList<>();
        int[] randomNum = getRandomNum(n);

        for (int num:randomNum) {
            Card cardTemp = cards.get(num);
            newCards.add(cardTemp);
            System.out.println(cardTemp.showCard(cardTemp));
        }

        return newCards;
    }
    // 获取不重复随机数组
    public static int[] getRandomNum(int n) {
        int[] randomList = new int[n];
        int numMax = Card.getCardNum();
        Random randomNum = new Random();

        for (int i = 0; i < n; ) {
            int temp = randomNum.nextInt(numMax); //[0,52)
            boolean flag = Arrays.asList(randomList).contains(temp);
            if (!flag) {
                randomList[i] = temp;
                i += 1;
            }
        }

        return randomList;
    }
}
