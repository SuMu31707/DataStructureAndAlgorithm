package com.sumu;

import java.util.Scanner;

public class NMulti {
    public static void main(String[] args) {
        int[] res = new int[10000];
        res[0] = 1;
        int len = 1;
        int tmp, up = 0;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要阶乘的数：");
        n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                tmp = res[j] * i + up;    //每次数组的每一位都乘以i加上来自低位的进位
                up = tmp / 10;    //处理进位
                res[j] = tmp % 10;
            }
            while (up > 0) { //进行进位，并将m的值进行了加1
                res[len++] = up % 10;
                up /= 10;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (res[i] != 0) { //删除前导零
                for (int j = i; j >= 0; j--)
                    System.out.print(res[j]);
                break;
            }
        }
    }

}
