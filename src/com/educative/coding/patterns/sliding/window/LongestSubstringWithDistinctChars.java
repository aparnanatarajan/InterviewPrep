package com.educative.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring, which has all distinct characters.
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring with distinct characters is "ab".
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 *
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N)O(N), where ‘N’ is the number of characters in the input string.
 *
 * Space Complexity#
 * The algorithm’s space complexity will be O(K)O(K), where KK is the number of distinct characters in the input
 * string. This also means K<=NK<=N, because in the worst case, the whole string might not have any duplicate
 * character, so the entire string will be added to the HashMap. Having said that, since we can expect a fixed
 * set of characters in the input string (e.g., 26 for English letters), we can say that the algorithm runs in
 * fixed space O(1)O(1); in this case, we can use a fixed-size array instead of the HashMap.
 */
public class LongestSubstringWithDistinctChars
{
    public static int findLength(String str)
    {
        if(str == null || str.length() == 0)
        {
            throw new IllegalArgumentException();
        }

        int startIndex = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int endIndex = 0; endIndex < str.length(); endIndex++)
        {
            char newChar = str.charAt(endIndex);
            charMap.put(newChar, charMap.getOrDefault(newChar, 0) + 1);
            while(charMap.get(newChar) > 1)
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

    public static void main(String[] args)
    {
        System.out.println("Length of the longest substring: " + findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + findLength("abbbb"));
        System.out.println("Length of the longest substring: " + findLength("abccde"));
    }
}
