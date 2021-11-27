package com.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 **/
public class ContainsDuplicateI
{
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)
        {
            return false;
        }

        Set<Integer> numSet = new HashSet<>();
        for(int num: nums)
        {
            if(!numSet.add(num))
            {
                return true;
            }
        }

        return false;
    }
}
