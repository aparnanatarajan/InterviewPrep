package com.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthLongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxLength = Integer.MIN_VALUE;
        int index = 0;
        int start = 0;
        Set<Character> charSet = new HashSet<>();
        while(index < s.length())
        {
            char currChar = s.charAt(index);
            if(charSet.add(currChar))
            {
                len++;
            }
            else
            {
                if(len > maxLength)
                {
                    maxLength = len;
                }
                while(start != index)
                {
                    char delChar = s.charAt(start);
                    start++;
                    if(delChar != currChar)
                    {
                        charSet.remove(delChar);
                        len--;
                    }
                    else
                    {
                        break;
                    }
                }

            }
            index++;
        }
        if(len > maxLength)
        {
            maxLength = len;
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        String input = "dvdf";
        int maxLength = lengthOfLongestSubstring(input);
        System.out.print("Max length of Substring: " + maxLength);
    }
}
