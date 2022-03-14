package com.educative.coding.patterns.sorting;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String args[])
    {
        int[] a = {4,3,2,10,12,1,5,6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a)
    {
        if(a == null || a.length < 2)
        {
            return;
        }
        for(int right = 1; right < a.length; right++)
        {
            int curr = a[right];
            int left = right - 1;
            while(left >=0 && a[left] > curr)
            {
                a[left + 1] = a[left];
                left--;
            }
            a[left + 1] = curr;
        }
    }
}
