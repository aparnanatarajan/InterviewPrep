package com.educative.coding.patterns.sliding.window;

import java.util.Arrays;
/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 *
 * For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
 * The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
 * For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
 *
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class AvgofAllContiguousSubarrays
{
    public static float[] getAvgofContiguousSubarrays(int[] a, int k)
    {
       if(a == null || a.length < k)
       {
           return null;
       }

       float[] avgArr = new float[a.length - k + 1];
       int count = 0;
       int sum = 0;
       for(int index = 0; index < a.length; index++)
       {
           sum += a[index];
           if(index >= k-1)
           {
               avgArr[index+1-k] = (float)sum/k;
               sum -= a[index+1-k];
           }
       }
       return avgArr;
    }

    public static void main(String args[])
    {
        int[] a = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        float[] res = getAvgofContiguousSubarrays(a, k);
        System.out.println(Arrays.toString(res));
    }
}
