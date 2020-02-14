package com.thoughtworks;

public enum CardValue {
    A(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    J(11, "J"),
    Q(12, "Q"),
    K(13, "K");

    private int value;
    private String str;

    CardValue(int value, String str) {
        this.value = value;
        this.str = str;
    }

    CardValue() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
