package com.sorting.algorithms;

import java.util.Arrays;

public class QuickSort
{
    public void quickSort(int[] a, int low, int high)
    {
        if(low < high)
        {
            int pivot = partition(a, low, high);
            if(low < pivot)
                quickSort(a, low, pivot);
            if(pivot+1 < high)
                quickSort(a, pivot+1, high);
        }
    }

    public int partition1(int[] a, int low, int high)
    {
        int i = low + 1;
        int pivot = a[low];
        for(int j = low+1; j<= high; j++)
        {
            if(a[j] < pivot)
            {
                swap(a, i, j);
                i += 1;
            }
            swap(a, low, i-1);
        }
        return i-1;
    }

    public int partition(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low;
        int j = high;
        while(i < j)
        {
            while(i < j && a[i] < pivot)
            {
                i++;
            }
            while(low+1 < j && a[j] >= pivot)
            {
                j--;
            }
            if(i < j)
            {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, low, j);
//        System.out.println(Arrays.toString(a));
        return j;
    }

    public void swap(int[] a, int low, int high)
    {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    public static void main(String[] args)
    {
        int[] a = {2,1,5,4,8,3};
//        int[] a = {5,6,3,2,3,4,1,9,8,7};
//        int[] a = {6,5,4,3,2,1,9,8,7,0};
//        int[] a = {5,4,3,2,1,0,7,-1,-2,-3,-4,-5,6};
        System.out.println(Arrays.toString(a));
        QuickSort q = new QuickSort();
        q.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
