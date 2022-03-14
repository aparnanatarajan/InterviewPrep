package com.leetcode.practice;

import java.util.Map;
import java.util.HashMap;

public class Solution
{
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }

        int maxLength = 0;
        int length = 0;
        int startIndex = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int endIndex = 0; endIndex < s.length(); endIndex++)
        {
            charMap.put(s.charAt(endIndex), charMap.getOrDefault(s.charAt(endIndex), 0)+1);
            while(charMap.get(s.charAt(endIndex)) > 1)
            {
                charMap.put(s.charAt(startIndex), charMap.get(s.charAt(startIndex))-1);
                startIndex++;
                maxLength = Math.max(maxLength, length);
            }
            length++;
        }

        return maxLength;
    }

    public static String longestPalindrome(String s)
    {
        if(s == null || s.length() == 0)
        {
            return null;
        }

        int start = 0;
        int maxLength = 0;
        int longStart = 0;
        int longEnd = 0;
        for(int end = 0; end < s.length(); end++)
        {
            while(!isPalindrome(s, start, end) && start <= end)
            {
                start++;
            }
            maxLength = Math.max(maxLength, start-end+1);
            if(maxLength == start-end+1)
            {
                longStart = start;
                longEnd = end;
            }
        }
        return s.substring(longStart, longEnd);
    }

    public static boolean isPalindrome(String s, int start, int end)
    {
        if(s == null || s.length()== 0)
        {
            return false;
        }

        if(s.length() == 1 || end - start + 1 == 1)
        {
            return true;
        }

        while(start < end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
//        String test = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(test));

        String test = "babad";
        System.out.println(longestPalindrome(test));
    }
}
