package com.educative.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
 *
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
 *
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 *
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N)O(N), where ‘N’ is the number of letters in the input string.
 *
 * Space Complexity#
 * As we expect only the lower case letters in the input string, we can conclude that the space complexity will be
 * O(26) to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1)O(1).
 */
public class LongestSubstringWithSameCharsAfterReplacement
{
    public static void main(String[] args)
    {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }

    public static int findLength(String str, int k)
    {
        if(str == null || str.length() == 0)
        {
            throw new IllegalArgumentException();
        }

        int startIndex = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int endIndex = 0; endIndex < str.length(); endIndex++)
        {
            char newChar = str.charAt(endIndex);
            charMap.put(newChar, charMap.getOrDefault(newChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charMap.get(newChar));

            int numReplacementChars = endIndex-startIndex+1-maxRepeatLetterCount;
            if(numReplacementChars > k)
            {
                char leftChar = str.charAt(startIndex);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if(charMap.get(leftChar) == 0)
                {
                    charMap.remove(leftChar);
                }
                startIndex++;
            }
            maxLength = Math.max(maxLength, endIndex-startIndex+1);
        }
        return maxLength;
    }
}
