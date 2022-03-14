package com.educative.coding.patterns.sliding.window;

/**
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 *
 * Time Complexity#
 * The time complexity of the above algorithm will be O(N).
 *
 * Space Complexity#
 * The algorithm runs in constant space O(1).
 */
public class MaxSumSubarray
{
    public static void main(String args[]) {
        int[] a = {2, 3, 4, 1, 5};
        int k = 2;
        System.out.println("maximum sum of any contiguous subarray of size " + k + " is " + findMaxSumSubArray(k, a)); // 7 - {3,4}

        int[] b = {2, 1, 5, 1, 3, 2};
        k=3;
        System.out.println("maximum sum of any contiguous subarray of size " + k + " is " + findMaxSumSubArray(k, b));// 9 - {5,1,3}
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        if(arr == null || arr.length < k)
        {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        for(int endIndex = 0; endIndex < arr.length; endIndex++)
        {
            sum += arr[endIndex];
            if(endIndex >= k-1)
            {
                maxSum = Math.max(maxSum, sum);
                sum-=arr[startIndex];
                startIndex++;
            }
        }
        return maxSum;
    }
}
