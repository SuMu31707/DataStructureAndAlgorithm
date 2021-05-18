package com.sumu.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数据
            insertValue = arr[i];
            // arr[i]前面这个数的下标
            insertIndex = i - 1;
            /**
             * 给insertValue找到要插入的位置
             * 1.insertIndex >= 0 保证给insertValue找插入位置不越界
             * 2.insertValue < arr[insertIndex]，待插入的数据还没找到要插入的位置
             * 3.就需要将arr[insertIndex]后移
             */
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明找到了插入的位置，insertIndex + 1
            arr[insertIndex +1] = insertValue;
            System.out.println("第"+i+"轮插入：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
