package com.sumu;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目：两数之和
 * 描述：给定一个整数数组nums，从数组中找出两个数之和满足相加之和等于目标数target
 * 假设每个输入只对应一个唯一的答案，而且不可以使用相同的元素；
 * 返回数组的下标，以数组形式返回
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println("暴力算法：" + Arrays.toString(solution1(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println("优化后的算法：" + Arrays.toString(solution2(new int[]{1, 2, 3, 4, 5, 6}, 10)));
    }

    // 暴力算法
    public static int[] solution1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }

            }
        }
        return res;
    }

    // 优化后的算法
    public static int[] solution2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
