package com.educative.coding.patterns.two.pointers;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Example 2:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum
{
    public static int[] search(int[] arr, int targetSum)
    {
        if(arr == null || arr.length < 2)
        {
            return new int[] { -1, -1 };
        }
        int low = 0;
        int high = arr.length - 1;
        while(low < high)
        {
            if(arr[low] + arr[high] == targetSum)
            {
                return new int[] {low, high};
            }
            if(arr[low] + arr[high] < targetSum)
            {
                low++;
            }
            else if(arr[low] + arr[high] > targetSum)
            {
                high--;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args)
    {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
