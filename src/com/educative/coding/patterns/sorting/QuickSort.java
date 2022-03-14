package com.educative.coding.patterns.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int[] a = {10, 80, 30, 90, 40, 50, 70};
//        sortMidPivot(a, 0, a.length - 1);
//        sortZeroPivot(a, 0, a.length - 1);
        sortHighPivot(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void sortZeroPivot(int[] a, int low, int high)
    {
        if(low < high)
        {
            int pivot = partitionZero(a, low, high);
            if(low < pivot)
                sortZeroPivot(a, low, pivot-1);
            if(pivot < high)
                sortZeroPivot(a, pivot+1, high);
        }
    }

    public static int partitionZero(int[] a, int low, int high)
    {
        int left = low;
        int right = high;
        int pivot = a[low];
        while(left < right)
        {
            while(a[left] <= pivot)
            {
                left++;
            }
            while(pivot < a[right])
            {
                right--;
            }
            if(left <= right)
            {
                swap(a, left, right);
                left++;
                right--;
            }
        }
        swap(a, low, right);
        return right;
    }
    public static void sortMidPivot(int[] a, int low, int high)
    {
        if(a == null || a.length < 2)
        {
            return;
        }
        if(low < high)
        {
            int left = low;
            int right = high;
            int mid = (left+right)/2;
            int pivot = a[mid];
            while(left <= right)
            {
                while(a[left] < pivot)
                {
                    left++;
                }
                while(a[right] > pivot)
                {
                    right--;
                }
                if(left <= right)
                {
                    swap(a, left, right);
                    left++;
                    right--;
                }
            }

            if(low < right)
            {
                sortMidPivot(a, low, right);
            }
            if(left < high)
            {
                sortMidPivot(a, left, high);
            }
        }

    }

    public static void sortHighPivot(int[] a, int low, int high)
    {
        if(low < high)
        {
            int pivot = partitionHigh(a, low, high);
            sortHighPivot(a, low, pivot-1);
            sortHighPivot(a, pivot+1, high);
        }
    }

    public static int partitionHigh(int[] a, int low, int high)
    {
        int pivot = a[high];
        int left = low;
        int right = high;

        while(left < right)
        {
            while(a[left] < pivot)
            {
                left++;
            }
            while(pivot <= a[right])
            {
                right--;
            }
            if(left < right)
            {
                swap(a, left, right);
                left++;
                right--;
            }
        }
        swap(a, left, high);
        return left;
    }

    public static void swap(int[] a, int low, int high)
    {
        int temp = a[low];
        a[low]= a[high];
        a[high] = temp;
    }
}
