package com.sumu;

public class SuShu {
    public static void main(String[] args) {
        System.out.println("暴力算法统计结果：" + bf(100));
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
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
