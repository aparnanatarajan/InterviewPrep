package com.educative.recursion.problems;

import java.util.Arrays;

public class SortArray
{
    public void quickSort(int[] a, int low, int high)
    {
        if(low < high)
        {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot-1);
            quickSort(a, pivot+1, high);
        }
    }

    public int partition(int[] a, int low, int high)
    {
        int pivot = (low+high)/2;
        int i = low;
        int j = high;
        while(i < j) {
            while ((i < j) && a[i] < pivot) {
                i++;
            }
            while (i < j && a[j] >= pivot) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return j;
    }

    public static void main(String[] args)
    {
//        int[] a = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        int[] a = {5,6,3,2,3,4,1,9,8,7};
        SortArray sa = new SortArray();
        sa.quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
