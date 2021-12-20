package com.leetcode.solutions.easy;

import java.util.ArrayList;
import java.util.List;

/***
 * Return the number of repeating characters to integer array
 * input: aab
 * output: [2, 1]
 */
public class NumberOfRepeatingCharacterArray {
    public static void main(String[] args) {
        final String input = "aabbc";
        System.out.println(solution(input));
    }

    private static List<Integer> solution(final String input) {
        final List<Integer> result = new ArrayList<>();

        int currentCharCount = 1;
        for(int i = 1; i < input.length(); i ++) {
            char prevChar = input.charAt(i - 1);
            char currentChar = input.charAt(i);
            if(prevChar == currentChar) {
                currentCharCount ++;
            } else {
                result.add(currentCharCount);
                currentCharCount = 1;
            }
        }

        result.add(currentCharCount);

        return result;
    }
}
