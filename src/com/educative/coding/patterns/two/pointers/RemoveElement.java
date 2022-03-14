package com.educative.coding.patterns.two.pointers;

/**
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the
 * new length of the array.
 *
 * Example 1:
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 *
 * Example 2:
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 * Solution: This problem is quite similar to our parent problem. We can follow a two-pointer approach and shift numbers left upon encountering the ‘key’.
 */
public class RemoveElement {
    public static int remove(int[] arr, int key)
    {
        if(arr == null || arr.length < 2)
        {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = 0;
        while(rightIndex < arr.length)
        {
            if(arr[rightIndex] != key)
            {
                arr[leftIndex] = arr[rightIndex];
                leftIndex++;
            }

            rightIndex++;
        }
        return leftIndex;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveElement.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveElement.remove(arr, 2));
    }
}