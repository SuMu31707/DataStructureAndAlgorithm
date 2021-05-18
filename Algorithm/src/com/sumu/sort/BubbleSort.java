package com.sumu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
//        int arr[] = {1, 2, 3, 4, 5};
        bubbleSort(arr);
    }

    // 将冒泡排序封装成方法
    public static void bubbleSort(int[] arr) {
        int temp = 0; // 临时变量，用于交换数据
        boolean flag = false; // 标识变量，用于标识每一趟循环中是否有过交换
        // 时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序结果：");
            System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            } else {
                flag = false; // 发生过交换，重置flag进行下一趟标识
            }
        }
    }
}
