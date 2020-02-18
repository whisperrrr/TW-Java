package com.thoughtworks;
/*
* 自动抽牌机
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class CardMachine {
    private Card card;

    public CardMachine() {
        this.card = new Card();
    }

    // 随机抽取n张牌
    public ArrayList<Card> drawCard(int n) {
        ArrayList<Card> cards = card.getCards();
        ArrayList<Card> newCards = new ArrayList<>();
        int[] randomNum = getRandomNum(n);

        for (int num:randomNum) {
            Card cardTemp = cards.get(num);
            newCards.add(cardTemp);
            System.out.print(cardTemp + " ");
        }

        return newCards;
    }
    // 获取不重复随机数组
    public int[] getRandomNum(int n) {
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
