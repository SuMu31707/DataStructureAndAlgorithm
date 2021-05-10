package com.sumu;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，请编写一个能够返回数组 “中心下标” 的方法。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心下标可能出现在数组的两端。
 */
public class ArrayCenterIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    /**
     * 思路：先统计出整个数组的总和，然后从第一个元素开始叠加
     * 总和递减当前元素，叠加递增当前元素，判断是否相等
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (sum == leftSum) {
                return i;
            }
            sum = sum - nums[i];
        }
        return -1;
    }
}
