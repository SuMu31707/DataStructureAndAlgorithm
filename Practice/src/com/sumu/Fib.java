package com.sumu;

/**
 * 斐波那契数列
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(calculate(10));
    }

    public static int calculate(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calculate(num-1) + calculate(num-2);
    }
}
