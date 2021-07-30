package com.sumu;

import java.util.Random;

/**
 * 随机生成5个[10, 35]之间的数，并且这5个数的和要为100
 */
public class Five10To35Sum100 {
    public static int[] getAns(int num, int tot, int lower, int upper) {
        //随机生成num个数，范围在[lower, upper]之间，他们的和为tot
        //如果不成功，返回null

        if (lower > upper) return null;
        int ans[] = new int[num];
        int n, x, y, a, b;
        Random r = new Random();

        for (int i = 0; i < num; i++) {
            //除去当前这个数，剩余还有n个数需要生成
            n = num - i - 1;

            //生成剩下n个数他们的取值为范围[x, y]
            x = lower * n;
            y = upper * n;

            //留给当前这个数的范围为U = [tot - y, tot - x]

            //V = [lower, upper]，将V 与 U求并集就是当前这个数的范围即，求得范围为[a, b]
            a = Math.max(lower, tot - y);
            b = Math.min(upper, tot - x);

            //如果a > b说明不能生成，直接返回null
            if (b - a + 1 <= 0) return null;

            //生成当前这个数
            ans[i] = r.nextInt(b - a + 1) + a;

            //tot减少
            tot -= ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 5;
        int tot = 100;
        int lower = 10;
        int upper = 35;
        int[] ans = getAns(num, tot, lower, upper);
        if (ans == null) {
            System.out.println("bad");
            return;
        }
        int z = 0;
        for (int i = 0; i < num; i++) {
            System.out.println(ans[i]);
            z += ans[i];
        }
        System.out.println("tot is " + z);
    }
}
