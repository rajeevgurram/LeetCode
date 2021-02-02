package com.leetcode.solutions.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        List<String> inputs = Arrays.asList("", " ", "abc", "aab", "abb", "abcdcderabcdef", "abceeeghrjskdef");
        for(String input : inputs) {
            int result = l.lengthOfLongestSubstring_1(input);
            System.out.println("lengthOfLongestSubstring for `" + input + "` : " + result);
        }
    }

    // Solution 1: Brute force O(N^2)
    public int lengthOfLongestSubstring_1(final String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        int length = 0, tempLength = 0;

        for(int i = 0; i < chars.length; i ++) {
            length = tempLength > length ? tempLength : length;
            tempLength = 0;
            for(int j = i; j < chars.length; j ++) {
                if(charMap.containsKey(chars[j])) {
                    //length = tempLength > length ? tempLength : length;
                    break;
                } else {
                    charMap.put(chars[j], j);
                    tempLength ++;
                }
            }
        }

        return length;
    }

    // Solution 2: Sliding Window Solution. O(N)
    public int lengthOfLongestSubstring_2(final String s) {
        int length = s.length();
        if(s.length() <= 1) {
            return length;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        int result = 0;
        int from = 0, to = 1;
        charMap.put(chars[from], from);

        for(to = 1; to < length; to ++) {
            if(from == to) {
                if(to + 1 < length) {
                    to += 1;
                } else {
                    break;
                }
            }
            Integer charIndex = charMap.get(chars[to]);
            if(charIndex != null && charIndex >= from) {
                    result = calculateLength(from, to, result);
                    from++;
                    to--;
            } else {
                charMap.put(chars[to], to);
            }
        }

        result = calculateLength(from, to, result);

        return result;
    }

    private int calculateLength(int from, int to, int length) {
        int newLength = to - from;
        return newLength > length ? newLength : length;
    }
}
