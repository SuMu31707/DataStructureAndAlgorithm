package com.sumu;

import java.util.Arrays;

/**
 * 题目：两数之和
 * 描述：给定一个“升序排列”的整数数组nums，从数组中找出两个数之和满足相加之和等于目标数target
 * 假设每个输入只对应一个唯一的答案，而且不可以使用相同的元素；
 * 返回数组的下标，以数组形式返回
 */
public class TwoSumByOrder {
    public static void main(String[] args) {
        System.out.println("二分查找算法：" + Arrays.toString(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println("双指针算法：" + Arrays.toString(twoPoint(new int[]{1, 2, 3, 4, 5, 6}, 10)));
    }

    // 二分法
    public static int[] binarySearch(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int low = i, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]) {
                    res[0] = i;
                    res[1] = mid;
                    return res;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return res;
    }

    // 双指针算法
    public static int[] twoPoint(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] res = new int[2];
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                res[0] = low;
                res[1] = high;
                return res;
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }
}
