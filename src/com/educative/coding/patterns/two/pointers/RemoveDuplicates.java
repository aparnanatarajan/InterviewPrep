package com.educative.coding.patterns.two.pointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after
 * removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 *
 * Example 1:
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 *
 * Example 2:
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates
{
    public static int remove(int[] arr)
    {
        if(arr == null || arr.length < 2)
        {
            return -1;
        }
        int uniqueIndex = 0;
        for(int index = 1; index < arr.length; index++)
        {
            if(arr[index] == arr[uniqueIndex])
            {
                continue;
            }
            else
            {
                uniqueIndex++;
                if(uniqueIndex != index)
                {
                    arr[uniqueIndex] = arr[index];
                }
            }
        }
        return uniqueIndex+1;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(remove(arr));
    }
}
