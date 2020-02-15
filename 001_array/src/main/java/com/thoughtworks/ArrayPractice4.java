package com.thoughtworks;

public class ArrayPractice4 {

    /**
     * 完成本方法实现功能: 将一个数字插入到给定的已经排好序的数组中，要求插入以后数组依然是有序的
     */
    public static int[] insert(int number) {
        int[] array = new int[]{1, 20, 50, 100};
        int arrayLen = array.length;
        int insertIndex = findIndex(array, number);
        int[] arrayInserted = new int[arrayLen + 1];
        for (int i = 0; i <= arrayLen; i++) {
            if (i == insertIndex) {
                arrayInserted[i] = number;
            } else if (i < insertIndex) {
                arrayInserted[i] = array[i];
            } else {
                arrayInserted[i] = array[i - 1];
            }
        }
        return arrayInserted;
    }

    private static int findIndex(int[] array, int number) {
        int index = 0;
        int indexLength = array.length;
        if (number > array[indexLength - 1]) {
            return indexLength;
        }
        for (int i = 0; i < indexLength; i++) {
            if (number < array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
