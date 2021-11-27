package com.sorting.algorithms;

import java.util.Arrays;

public class MergeSort
{
    public void sort(int[] a, int low, int high)
    {
        int pivot = (high-low)/2;
        sort(a, low, pivot);
        sort(a, pivot+1, high);
        merge(a, low, high, pivot);
    }

    public void merge(int[] a, int low, int high, int pivot)
    {
        int temp[] = new int[high-low+1];
        int i = low;
        int j = pivot+1;
        int k = low;

        while(i <= pivot && j <= high)
        {
            if(a[i] <= a[j])
            {
                temp[k] = a[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = a[j];
                j++;
                k++;
            }
        }
        while(i <= pivot)
        {
            temp[k] = a[i];
            i++;
            k++;
        }
        while(j <= high)
        {
            temp[k] = a[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5,6,3,2,3,4,1,9,8,7};
        MergeSort m = new MergeSort();
        m.sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
