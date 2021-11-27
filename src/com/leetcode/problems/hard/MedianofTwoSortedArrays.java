package com.leetcode.problems.hard;

public class MedianofTwoSortedArrays
{
//    public static double findMedianSortedArraysQS(int[] nums1, int[] nums2)
//    {
//
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int totalLength = nums1.length + nums2.length;
        int med = totalLength/2;
        if(nums1.length == 0 && nums2.length == 0)
        {
            return 0;
        }
        if(nums1.length == 0)
        {
            return getMedian(totalLength, nums2);
        }
        if(nums2.length == 0)
        {
            return getMedian(totalLength, nums1);
        }

        int[] res = new int[med+1];
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while(index1 < nums1.length || index2 < nums2.length)
        {
            if(index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2])
            {
                res[count] = nums1[index1];
                index1++;
                count++;
            }
            else
            {
                if(index2 >= nums2.length)
                {
                    res[count] = nums1[index1];
                    index1++;
                    count++;
                }
                else
                {
                    res[count] = nums2[index2];
                    index2++;
                    count++;
                }
            }

            if(count == med+1)
            {
                break;
            }
        }
        return getMedian(totalLength, res);
    }

    public static double getMedian(int totalLength, int[] res)
    {
        int med = totalLength / 2;
        if(totalLength % 2 == 0)
        {
            return (double)(res[med] + res[med-1])/2;
        }
        else
        {
            return res[med];
        }
    }

    public static void main(String[] args)
    {
        int[] a = {};
        int[] b = {};

        System.out.print(findMedianSortedArrays(a,b));
    }
}
