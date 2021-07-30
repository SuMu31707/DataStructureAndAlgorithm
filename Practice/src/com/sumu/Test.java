package com.sumu;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] res = {23, 58, 63, 45, 69, 11, 27, 38};

        for (int i = 0; i < res.length; i++) {
            while (res[i] <= 0 || res[i] >= 10) {
                res[i] = res[i] / 10 + res[i] % 10;
            }
        }

        System.out.println(Arrays.toString(res));
    }
}
