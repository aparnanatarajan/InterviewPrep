package com.sorting.algorithms;

import java.util.List;

public class InsertionSort {
    public static void sort(int[] nums) {
        for(int i = 1; i < nums.length; i++)
        {
            int num = nums[i];
            int j = i-1;
            while(j >= 0 && nums[j] > num)
            {
                if(nums[j] > num)
                {
                    nums[j+1] = nums[j];
                    j--;
                }
            }
            nums[j+1] = num;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {5,6,2,4,8,1,3};
        sort(nums);

        for(int num: nums)
        {
            System.out.println(num);
        }
    }
}
