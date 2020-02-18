package com.thoughtworks;

public enum CardName {
    SPADE("黑桃"), HEART("红桃"), CLUB("梅花"), DIAMOND("方片");

    private String chineseStr;

    private CardName(String chineseStr) {
        this.chineseStr = chineseStr;
    }

    public String getChineseStr() {
        return chineseStr;
    }
}
