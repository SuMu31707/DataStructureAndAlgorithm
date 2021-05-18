package com.sumu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*int arr[] = {3, 9, -1, 10, 20};

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));*/

        /**
         * 测试冒泡排序的执行时间，给80000个数据进行测试
         * 创建一个长度为80000的数组，里面填充8万个(0-8000000)随机数
         */

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000)的随机数
        }

        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("程序共执行了：" + (endTime - startTime) + "ms");
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
//            System.out.println("第" + (i + 1) + "趟排序结果：");
//            System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            } else {
                flag = false; // 发生过交换，重置flag进行下一趟标识
            }
        }
    }
}
