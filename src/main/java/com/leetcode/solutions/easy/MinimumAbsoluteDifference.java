package com.leetcode.solutions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/minimum-absolute-difference/
 */
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
//        final int[] input = {4,2,1,3};
        final int[] input = {1,3,6,10,15};
        System.out.println(minimumAbsDifference(input));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        final List<List<Integer>> response = new ArrayList<>();
        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            minDifference = Math.min(minDifference, arr[i] - arr[i - 1]);
        }

        for(int i = 1; i < arr.length; i++) {
            int difference = arr[i] - arr[i - 1];
            if(difference == minDifference) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                response.add(pair);
            }
        }

        return response;
    }
}
