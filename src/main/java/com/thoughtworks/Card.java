package com.thoughtworks;

import java.util.ArrayList;

/*
* 成员属性：花色（枚举），牌面（枚举），一副牌（static代码块）
* 成员方法：显示一张牌
* */
public class Card {
    private CardValue cardValue;
    private CardName cardName;
    private static ArrayList<Card> cards = new ArrayList<Card>();
    //构造函数
    public Card() {
    }

    public Card(CardValue cardValue, CardName cardName) {
        this.cardValue = cardValue;
        this.cardName = cardName;
    }
    // Getter and Setter
    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public CardName getCardName() {
        return cardName;
    }

    public void setCardName(CardName cardName) {
        this.cardName = cardName;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Card.cards = cards;
    }

    // 初始化一副牌
    static {
        for (CardName name:CardName.values()) {
            for (CardValue value:CardValue.values()) {
                cards.add(new Card(value, name));
            }
        }
    }

    // 显示一张牌
    public static String showCard(Card card) {
        return card.getCardName().name() + card.getCardValue().getStr();
    }

}
