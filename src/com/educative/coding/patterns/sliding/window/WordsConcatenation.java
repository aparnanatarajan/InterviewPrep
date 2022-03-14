package com.educative.coding.patterns.sliding.window;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string that are a
 * concatenation of all the given words exactly once without any overlapping of words. It is given that all words
 * are of the same length.
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 *
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 *
 * Time Complexity#
 * The time complexity of the above algorithm will be O(N * M * Len)O(N∗M∗Len) where ‘N’ is the number of characters
 * in the given string, ‘M’ is the total number of words, and ‘Len’ is the length of a word.
 *
 * Space Complexity#
 * The space complexity of the algorithm is O(M)O(M) since at most, we will be storing all the words in the two
 * HashMaps. In the worst case, we also need O(N)O(N) space for the resulting list. So, the overall space complexity
 * of the algorithm will be O(M+N).O(M+N).
 */
public class WordsConcatenation
{
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
