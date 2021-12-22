package com.leetcode.solutions.easy;

/***
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 1, 1}));
    }

    public static boolean isMonotonic(int[] nums) {
        if(nums.length < 2) {
            return true;
        }

        // if array has same numbers, just increase the index
        int index = 1;
        while(nums.length > index && nums[index] == nums[index - 1]) {
            index++;
        }

        if(index == nums.length) {
            return true;
        }

        boolean isIncreasing = nums[index - 1] < nums[index];
        for(; index < nums.length; index++) {
            if(isIncreasing) {
                if(nums[index] < nums[index - 1]) {
                    return false;
                }
            } else {
                if(nums[index] > nums[index - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
