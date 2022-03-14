package com.educative.coding.patterns.sliding.window;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of
 * the longest contiguous subarray having all 1s.
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 *
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 *
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N), where ‘N’ is the count of numbers in the input array.
 *
 * Space Complexity#
 * The algorithm runs in constant space O(1).
 */
public class LongestSubarrayWithOnesAfterReplacement
{
    public static int findLength(int[] arr, int k)
    {
        if(arr == null || arr.length == 0)
        {
            throw new IllegalArgumentException();
        }

        int startIndex = 0;
        int maxLength = 0;
        int countOnes = 0;
        for(int endIndex = 0; endIndex < arr.length; endIndex++)
        {
            if(arr[endIndex] == 1)
            {
                countOnes++;
            }

            if(endIndex - startIndex + 1 - countOnes > k)
            {
                if(arr[startIndex] == 1)
                {
                    countOnes--;
                }
                startIndex++;
            }
            maxLength = endIndex - startIndex + 1;
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        System.out.println(findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
