package com.educative.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 *
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 *
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 *
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 *
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N + M)O(N+M), where ‘N’ and ‘M’ are the number of characters in
 * the input string and the pattern, respectively.
 *
 * Space Complexity#
 * The algorithm’s space complexity is O(M)O(M) since, in the worst case, the whole pattern can have distinct
 * characters that will go into the HashMap.
 */
public class PermutationofPatternInaString
{
    public static boolean findPermutation(String str, String pattern)
    {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++)
        {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar))
            {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }
            if (matched == charFrequencyMap.size())
                return true;
            if (windowEnd >= pattern.length() - 1)
            { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar))
                {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
