package com.leetcode.solutions.easy;

/***
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    private static int solution(final int number) {
        if(number <= 1) {
            return number;
        }
        return solution(number - 1) + solution(number - 2);
    }
}
