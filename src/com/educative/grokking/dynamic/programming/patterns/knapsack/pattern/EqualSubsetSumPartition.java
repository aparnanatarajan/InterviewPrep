package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

/**
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both
 * the subsets is equal.
 *
 * Example 1:#
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2:#
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3:#
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
public class EqualSubsetSumPartition
{
    boolean canPartition(int[] num) {
        if(num == null || num.length == 0)
        {
            return false;
        }

        int sum = 0;
        for(int index = 0; index < num.length; index++)
        {
            sum += num[index];
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        return canPartition(num, sum/2, 0);
    }

    boolean canPartition(int[] num, int sum, int currentIndex)
    {
        if(sum == 0)
        {
            return true;
        }

        if(currentIndex >= num.length)
        {
            return false;
        }

        if(num[currentIndex] <= sum && canPartition(num, sum-num[currentIndex], currentIndex+1))
        {
            return true;
        }
        return canPartition(num, sum, currentIndex+1);
    }

    public boolean canPartitionTopDown(int[] num)
    {
        if(num == null || num.length == 0)
        {
            return false;
        }

        int sum = 0;
        for(int index = 0; index < num.length; index++)
        {
            sum += num[index];
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        Boolean[][] memo = new Boolean[num.length][sum/2 + 1];
        return canPartitionTopDown(num, sum/2, 0, memo);
    }

    public boolean canPartitionTopDown(int[] num, int sum, int currentIndex, Boolean[][] memo)
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

        boolean canPartition = canPartitionTopDown(num, sum, currentIndex+1, memo);
        memo[currentIndex][sum] = canPartition;
        return canPartition;
    }

    public static void main(String[] args)
    {
        EqualSubsetSumPartition partitionSet = new EqualSubsetSumPartition();
        int[] num = {1, 2, 3, 4};
        System.out.println(partitionSet.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(partitionSet.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(partitionSet.canPartition(num));
    }
}
