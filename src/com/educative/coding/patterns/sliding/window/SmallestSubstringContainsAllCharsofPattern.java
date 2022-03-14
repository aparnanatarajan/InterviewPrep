package com.educative.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the characters of the
 * given pattern.
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 *
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 *
 * Time Complexity#
 * The time complexity of the above algorithm will be O(N + M)O(N+M) where ‘N’ and ‘M’ are the number of characters
 * in the input string and the pattern respectively.
 *
 * Space Complexity#
 * The space complexity of the algorithm is O(M)O(M) since in the worst case, the whole pattern can have distinct
 * characters which will go into the HashMap. In the worst case, we also need O(N)O(N) space for the resulting
 * substring, which will happen when the input string is a permutation of the pattern.
 */
public class SmallestSubstringContainsAllCharsofPattern
{
    public static String findSubstring(String str, String pattern) {
        if(str == null || str.length() == 0 || pattern == null || pattern.length() == 0)
        {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for(int index = 0; index < pattern.length(); index++)
        {
            char currChar = pattern.charAt(index);
            charMap.put(currChar, charMap.getOrDefault(currChar, 0) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        String smallestSubstring = "";
        int matches = 0;
        for(int endIndex = 0; endIndex < str.length(); endIndex++)
        {
            char rightChar = str.charAt(endIndex);
            if(charMap.containsKey(rightChar))
            {
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if(charMap.get(rightChar) >= 0)
                {
                    matches++;
                }
            }
            int length = 0;
            while(matches == pattern.length())
            {
                length = endIndex - startIndex + 1;
                if(length < minLength)
                {
                    smallestSubstring = str.substring(startIndex, startIndex + length);
                    minLength = length;
                }

                char leftChar = str.charAt(startIndex);
                if(charMap.containsKey(leftChar))
                {
                    if(charMap.get(leftChar) == 0)
                    {
                        matches--;
                    }
                    charMap.put(leftChar, charMap.get(leftChar)+1);
                }
                startIndex++;

            }
        }
        return smallestSubstring;
    }

    public static void main(String[] args)
    {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
