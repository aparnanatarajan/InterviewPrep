package com.educative.coding.patterns.sliding.window;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while
 * finding permutations of a string, we get N!N! permutations (or anagrams) of a string having NN characters.
 * For example, here are the six anagrams of the string “abc”:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 *
 * Time Complexity#
 * The time complexity of the above algorithm will be O(N + M) where ‘N’ and ‘M’ are the number of characters
 * in the input string and the pattern respectively.
 *
 * Space Complexity#
 * The space complexity of the algorithm is O(M) since in the worst case, the whole pattern can have distinct
 * characters which will go into the HashMap. In the worst case, we also need O(N) space for the result list,
 * this will happen when the pattern has only one character and the string contains only that character.
 */
public class AnagramsofPatternInString
{
    public static List<Integer> findStringAnagrams(String str, String pattern)
    {
        List<Integer> resultIndices = new ArrayList<>();
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
        int startIndex = 0;
        int matches = 0;
        for(int endIndex = 0; endIndex < str.length(); endIndex++)
        {
            char rightChar = str.charAt(endIndex);
            if(charMap.containsKey(rightChar))
            {
                charMap.put(rightChar, charMap.get(rightChar)-1);
                if(charMap.get(rightChar) == 0)
                {
                    // we have a match
                    matches++;
                }
            }
            if(matches == charMap.size())
            {
                resultIndices.add(startIndex);
            }
            if(endIndex >= pattern.length()-1)
            {
                // remove char at startIndex and move it up by 1
                char leftChar = str.charAt(startIndex);
                if(charMap.containsKey(leftChar))
                {
                    if(charMap.get(leftChar) == 0)
                        matches--;
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
                startIndex++;
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }
}
