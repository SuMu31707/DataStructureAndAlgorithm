package com.sumu;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：统计n以内的素数个数
 * 素数：只能被1和自身整除的自然数，0和1除外
 * 例如：输入100，输出25
 * 考察重点：埃塞法
 */
public class SuShu {
    public static void main(String[] args) {
        System.out.println("暴力算法统计结果：" + bf(100));
        System.out.println("埃塞法统计结果：" + eratosthenes(100));
    }

    // 暴力算法统计素数个数
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        // 将i<n优化成i*i<n，只判断到根号x
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃塞法统计素数个数
     * 素数  非素数（合数） 12 = 2 * 6
     */
    public static int eratosthenes(int n) {
        // 建立标记位数组，数组中每个元素默认为false，此处false代表素数
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                // 此处 j = i*i会造成j溢出int的最大值
                for (int j = i * i; j < n; j += i) {
                    // j就是合数的位置
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

}
