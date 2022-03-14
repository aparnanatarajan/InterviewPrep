package com.educative.grokking.dynamic.programming.patterns.unbounded.knapsack.pattern;

/**
 * Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the minimum
 * number of coins needed to make up that amount.
 *
 * Example 1:
 *
 * Denominations: {1,2,3}
 * Total amount: 5
 * Output: 2
 * Explanation: We need a minimum of two coins {2,3} to make a total of '5'
 * Example 2:
 *
 * Denominations: {1,2,3}
 * Total amount: 11
 * Output: 4
 * Explanation: We need a minimum of four coins {2,3,3,3} to make a total of '11'
 *
 * Given a number array to represent different coin denominations and a total amount ‘T’, we need to find the
 * minimum number of coins needed to make a change for ‘T’. We can assume an infinite supply of coins, therefore,
 * each coin can be chosen multiple times.
 */
public class MinimumCoinChange
{
    public int countChange(int[] denominations, int total) {
        if(denominations == null || denominations.length == 0 || total == 0)
            return 0;
        int count = countChange(denominations, total, 0);
        return (count == Integer.MAX_VALUE? 0: count);
    }

    public int countChange(int[] denominations, int total, int currentIndex)
    {
        if(total == 0)
        {
            return 0;
        }

        if( currentIndex >= denominations.length || total < 0)
        {
            return Integer.MAX_VALUE;
        }
        int countIncl = Integer.MAX_VALUE;
        if(denominations[currentIndex] <= total)
        {
            int tempCount = countChange(denominations, total - denominations[currentIndex], currentIndex);
            if(tempCount != Integer.MAX_VALUE)
                countIncl = 1 + tempCount;
        }
        int countExcl = countChange(denominations, total, currentIndex + 1);

        return Math.min(countIncl, countExcl);
    }
    public static void main(String[] args) {
        MinimumCoinChange cc = new MinimumCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}
