package com.sumu;

/**
 * 题目：求x的平方根
 * 要求：在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
 * 考察重点：二分法、牛顿迭代法
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(binarySearch(81));
    }

    // 二分查找法
    public static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return index;
    }

    // 牛顿迭代法

}
