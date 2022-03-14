package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
 *
 * Example 1:#
 * Input: {1, 1, 2, 3}, S=4
 * Output: 3
 * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
 * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
 * Example 2:#
 * Input: {1, 2, 7, 1, 5}, S=9
 * Output: 3
 * The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
 */
public class CountSubsetSum
{
    static int countSubsets(int[] num, int sum)
    {
        if(num == null || num.length == 0)
        {
            return 0;
        }
        return countSubsets(num, sum, 0);
    }

    static int countSubsets(int[] num, int sum, int currentIndex)
    {
        if(sum == 0)
        {
            return 1;
        }

        if(num.length == 0 || currentIndex >= num.length)
        {
            return 0;
        }

        int count = 0;
        if(num[currentIndex] <= sum)
        {
            count += countSubsets(num, sum-num[currentIndex], currentIndex+1);
        }

        return count + countSubsets(num, sum, currentIndex+1);
    }

    static int countSubsetsTopDown(int[] num, int sum)
    {
        if(num == null || num.length == 0)
        {
            return 0;
        }

        int[][] countMemo = new int[num.length][sum+1];
        return countSubsetsTopDown(num, sum, 0, countMemo);
    }

    static int countSubsetsTopDown(int[] num, int sum, int currentIndex, int[][] countMemo)
    {
        if(sum == 0)
        {
            return 1;
        }

        if(num.length == 0 || currentIndex >= num.length)
        {
            return 0;
        }

        if(countMemo[currentIndex][sum] == 0)
        {
            int count = 0;
            if(num[currentIndex] <= sum)
            {
                count += countSubsetsTopDown(num, sum - num[currentIndex], currentIndex + 1, countMemo);
            }
            count += countSubsetsTopDown(num, sum, currentIndex + 1, countMemo);
            countMemo[currentIndex][sum] = count;
        }
        return countMemo[currentIndex][sum];
    }

    public static void main(String[] args)
    {
        CountSubsetSum ss = new CountSubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsetsTopDown(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsetsTopDown(num, 9));
    }
}
