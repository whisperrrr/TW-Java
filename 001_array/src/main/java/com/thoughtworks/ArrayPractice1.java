package com.thoughtworks;

import java.util.Arrays;

public class ArrayPractice1 {

    public static void main(String[] args) {
        printArrayReverse();
    }

    /**
     * 倒序打印给定数组,打印格式为: [3,2,1]
     */
//方法一：左右交换法
//    public static void printArrayReverse() {
//        int[] array = new int[]{1, 2, 3};
//        for (int left = 0,right = array.length - 1; left < right; left++, right--) {
//            int temp = array[left];
//            array[left] = array[right];
//            array[right] = temp;
//        }
//        System.out.println(Arrays.toString(array));
//    }
//方法二：倒叙打印
    public static void printArrayReverse() {
        int[] array = new int[]{1, 2, 3};
        int arrayLen = array.length;
        int[] reverseArray = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            reverseArray[arrayLen - i - 1] = array[i];
        }
        System.out.println(Arrays.toString(reverseArray));
    }
}
