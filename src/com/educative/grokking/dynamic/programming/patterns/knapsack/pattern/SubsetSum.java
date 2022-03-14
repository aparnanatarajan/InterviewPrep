package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

/**
 * Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.
 *
 * Example 1:#
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 * Example 2:#
 * Input: {1, 2, 7, 1, 5}, S=10
 * Output: True
 * The given set has a subset whose sum is '10': {1, 2, 7}
 * Example 3:#
 * Input: {1, 3, 4, 8}, S=6
 * Output: False
 * The given set does not have any subset whose sum is equal to '6'.
 */
public class SubsetSum
{
    boolean canPartition(int[] num, int sum)
    {
        if(num == null || num.length == 0)
        {
            return false;
        }

        return canPartition(num, sum, 0);
    }

    boolean canPartition(int[] num, int sum, int currIndex)
    {
        if(sum == 0)
        {
            return true;
        }

        if(currIndex >= num.length)
        {
            return false;
        }

        if(num[currIndex] <= sum)
        {
            if(canPartition(num, sum - num[currIndex], currIndex + 1))
            {
                return true;
            }
        }

        return canPartition(num, sum, currIndex + 1);
    }

    boolean canPartitionTopDown(int[] num, int sum)
    {
        if(num == null || num.length == 0)
        {
            return false;
        }

        Boolean[][] memo = new Boolean[num.length][sum+1];
        return canPartitionTopDown(num, sum, 0, memo);
    }

    boolean canPartitionTopDown(int[] num, int sum, int currentIndex, Boolean[][] memo)
    {
        if(sum == 0)
        {
            return true;
        }

        if(currentIndex >= num.length)
        {
            return false;
        }

        if(memo[currentIndex][sum] != null)
        {
            return memo[currentIndex][sum];
        }

        if(num[currentIndex] <= sum)
        {
            if(canPartitionTopDown(num, sum - num[currentIndex], currentIndex + 1, memo))
            {
                memo[currentIndex][sum] = true;
                return true;
            }
        }

        boolean canPartition = canPartitionTopDown(num, sum, currentIndex + 1, memo);
        memo[currentIndex][sum] = canPartition;
        return canPartition;
    }

    public static void main(String[] args)
    {
        SubsetSum subsetSum = new SubsetSum();
        int[] num = {1, 2, 3, 4};
        int sum = 6;
        System.out.println(subsetSum.canPartitionTopDown(num, sum));
        num = new int[]{1, 1, 3, 4, 7};
        sum = 10;
        System.out.println(subsetSum.canPartitionTopDown(num, sum));
        num = new int[]{1,3,4,8};
        sum =  6;
        System.out.println(subsetSum.canPartitionTopDown(num, sum));
    }
}
