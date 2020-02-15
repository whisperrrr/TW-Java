package com.thoughtworks;

import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class App {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请点餐（菜品Id x 数量，用逗号隔开）：");
    String selectedItems = scan.nextLine();
    String summary = bestCharge(selectedItems);
    System.out.println(summary);
  }

  /**
   * 接收用户选择的菜品和数量，返回计算后的汇总信息
   *
   * @param selectedItems 选择的菜品信息
   */
//  ============= 订餐明细 =============
//  黄焖鸡 x 1 = 18元
//  肉夹馍 x 2 = 12元
//  凉皮 x 1 = 8元
//-----------------------------------
//  使用优惠:
//  指定菜品半价(黄焖鸡，凉皮)，省13元
//-----------------------------------
//  总计：25元
//===================================
  public static String bestCharge(String selectedItems) {
    // 获取基本信息
    String[] itemIds = getItemIds();
    String[] itemNames = getItemNames();
    double[] ItemPrices = getItemPrices();
    String[] HalfPriceIds = getHalfPriceIds();
    String[] selectedItemsList = selectedItems.split(",");

    double countTotal = 0;
    double countHalf = 0;
    String billShowList = "";

    int selectedItemsLen = selectedItemsList.length;
    for (int i = 0; i < selectedItemsLen; i++) {
      String[] item = selectedItemsList[i].split(" x ");
      int itemIndex = 0;
      double itemCount = 0;
      for (int j = 0; j < itemIds.length; j++) {
        if (item[0].equals(itemIds[j])) {
          itemIndex = j;
          break;
        }
      }
      itemCount = ItemPrices[itemIndex] * Double.valueOf(item[1]);
      countTotal += itemCount;
      countHalf += itemIndex == 0 || itemIndex == 2? itemCount * 0.5: itemCount;
      billShowList += itemNames[itemIndex] + " x " + item[1] + " = " +String.valueOf((int)itemCount) + "元" +'\n';
    }

    // 选择何种优惠方式
    String discountShowList = chooseDiscount(countHalf,countTotal);
    String countTotalShowList = chooseTotalDiscount(countHalf,countTotal);
    // 最终输出
    String billShowTotal = "============= 订餐明细 =============" + '\n'
            + billShowList
            + "-----------------------------------" + '\n'
            + discountShowList
            + countTotalShowList
            + "===================================";
    return billShowTotal;
  }
  /**
   * 显示总价
   */
  public static String chooseTotalDiscount(double countHalf,double countTotal) {
    String totalDiscountShow = "";
    double overThirty = Math.floor(countTotal / 30) * 6;
    double countOver = countTotal - overThirty;
    double countMin = Math.min(countHalf,countOver);
    totalDiscountShow += "总计：" + String.valueOf((int)countMin) + "元" + '\n';
    return totalDiscountShow;
  }

  /**
   * 显示何种优惠方式
   */
  public static String chooseDiscount(double countHalf,double countTotal) {
    String discountShow = "";
    double overThirty = Math.floor(countTotal / 30) * 6;
    double countOver = countTotal - overThirty;
    if (countOver <= countHalf) {
      if (countOver == countTotal) {
        return "";
      }
      discountShow += "使用优惠:" + '\n' + "满30减6元，省" + String.valueOf((int)overThirty) + "元" + '\n';
    } else {
      discountShow += "使用优惠:" + '\n' + "指定菜品半价(黄焖鸡，凉皮)，省" + String.valueOf((int)(countTotal-countHalf)) + "元" + '\n';
    }
    discountShow += "-----------------------------------" + '\n';
    return discountShow;
  }
  /**
   * 获取每个菜品依次的编号
   */
  public static String[] getItemIds() {
    return new String[]{"ITEM0001", "ITEM0013", "ITEM0022", "ITEM0030"};
  }

  /**
   * 获取每个菜品依次的名称
   */
  public static String[] getItemNames() {
    return new String[]{"黄焖鸡", "肉夹馍", "凉皮", "冰粉"};
  }

  /**;
   * 获取每个菜品依次的价格
   */
  public static double[] getItemPrices() {
    return new double[]{18.00, 6.00, 8.00, 2.00};
  }

  /**
   * 获取半价菜品的编号
   */
  public static String[] getHalfPriceIds() {
    return new String[]{"ITEM0001", "ITEM0022"};
  }
}
