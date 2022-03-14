package com.educative.coding.patterns.sorting;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String args[])
    {
        int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println("Sorted array " + Arrays.toString(arr));

    }

    public static void sort(int[] a)
    {
        if(a == null || a.length < 1)
        {
            return;
        }

        for(int index = 0; index < a.length-1; index++)
        {
            int minIndex = index;
            int nextIndex = index+1;
            for(; nextIndex < a.length; nextIndex++)
            {
                if(a[nextIndex] < a[minIndex])
                {
                    minIndex = nextIndex;
                }
            }
            swap(a, minIndex, index);
        }
    }

    public static void swap(int[] a, int low, int high)
    {
        int temp = a[low];
        a[low]= a[high];
        a[high] = temp;
    }
}
