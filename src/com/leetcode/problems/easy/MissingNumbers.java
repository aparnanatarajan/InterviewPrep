package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 **/
public class MissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int index = 0; index < nums.length; index++)
        {
            int count = Math.abs(nums[index]) - 1;
            if(nums[count] > 0)
            {
                nums[count] = -nums[count];
            }
        }

        for(int index = 0; index < nums.length; index++)
        {
            int num = nums[index];
            if(num > 0)
            {
                numList.add(index+1);
            }
        }

        return numList;
    }
}
