package com.educative.coding.patterns.sorting;

import java.util.Arrays;

public class MergeKSortedArrays
{
    public static void main(String[] args)
    {
        int[][] a = {
                {1,3,5,7},
                {2,4,6,8},
                {0,9,10,11}
        };

        System.out.println(Arrays.toString(mergeArrays(a)));
    }

    public static int[] mergeArrays(int[][] a)
    {
        if(a == null || a.length == 0)
        {
            return null;
        }
        else if(a.length < 2)
        {
            return a[0];
        }

        int size = 0;
        int k = 0;

        for(int i=0; i < a.length; i++)
        {
            size += a[i].length;
        }

        int[] merged = new int[size];
        int[] temp1 = a[0];

        for(int count = 1; count < a.length; count++)
        {
            int[] temp2 = a[count];
            int i = 0;
            int j = 0;
            while(i < temp1.length && j < temp2.length)
            {
                if(temp1[i] <= temp2[j])
                {
                    merged[k++] = temp1[i++];
                }
                else if(temp1[i] > temp2[j])
                {
                    merged[k++] = temp2[j++];
                }
                while(i < temp1.length)
                {
                    merged[k++] = temp1[i++];
                }
                while(j < temp2.length)
                {
                    merged[k++] = temp2[j++];
                }
                temp1 = merged;
            }
        }
        return merged;
    }
}
