package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

/**
 * Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign. We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.
 *
 * Example 1:#
 * Input: {1, 1, 2, 3}, S=1
 * Output: 3
 * Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 * Example 2:#
 * Input: {1, 2, 7, 1}, S=9
 * Output: 2
 * Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
 */
public class TargetSum
{
    public int findTargetSubsets(int[] num, int s)
    {
        if(num == null || num.length == 0)
        {
            return 0;
        }

        int numSum = 0;
        for(int index = 0; index < num.length; index++)
        {
            numSum += num[index];
        }

        if(numSum < s || (numSum + s) % 2 != 0)
            return 0;
        int target = (numSum + s)/2;
        return findTargetSubsets(num, target, 0);
    }

    public int findTargetSubsets(int[] num, int target, int currentIndex)
    {
        if(target == 0)
        {
            return 1;
        }

        if(num.length == 0 || currentIndex >= num.length)
        {
            return 0;
        }

        int count = 0;
        if(num[currentIndex] <= target)
        {
            count += findTargetSubsets(num, target-num[currentIndex], currentIndex + 1);
        }
        return count + findTargetSubsets(num, target, currentIndex + 1);
    }

    public int findTargetSubsetsTopDown(int[] num, int s)
    {
        if(num == null || num.length == 0)
        {
            return 0;
        }

        int numSum = 0;
        for(int index = 0; index < num.length; index++)
        {
            numSum += num[index];
        }

        if(numSum < s || (numSum + s) % 2 != 0)
        {
            return 0;
        }

        int target = (numSum + s)/2;
        int[][] memo = new int[num.length][target+1];

        return findTargetSubsetsTopDown(num, target, 0, memo);
    }

    public int findTargetSubsetsTopDown(int[] num, int target, int currentIndex, int[][] memo)
    {
        if(target == 0)
        {
            return 1;
        }

        if(num.length == 0 || currentIndex >= num.length)
        {
            return 0;
        }

        if(memo[currentIndex][target] != 0)
        {
            return memo[currentIndex][target];
        }

        int count = 0;
        if(num[currentIndex] <= target)
        {
            count += findTargetSubsetsTopDown(num, target - num[currentIndex], currentIndex + 1, memo);
        }
        count += findTargetSubsetsTopDown(num, target, currentIndex + 1, memo);
        memo[currentIndex][target] = count;

        return count;
    }

    public static void main(String[] args)
    {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsetsTopDown(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsetsTopDown(num, 9));
    }
}
