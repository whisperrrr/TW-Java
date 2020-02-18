package com.thoughtworks;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    CardMachine cardMachine = new CardMachine();
    int num = getNum();
    cardMachine.drawCard(num);
  }

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
}
