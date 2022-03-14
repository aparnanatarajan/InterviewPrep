package com.educative.grokking.dynamic.programming.patterns.unbounded.knapsack.pattern;

/**
 * Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total number
 * of distinct ways to make up that amount.
 *
 * Example:
 *
 * Denominations: {1,2,3}
 * Total amount: 5
 * Output: 5
 * Explanation: There are five ways to make the change for '5', here are those ways:
 *   1. {1,1,1,1,1}
 *   2. {1,1,1,2}
 *   3. {1,2,2}
 *   4. {1,1,3}
 *   5. {2,3}
 * Problem Statement#
 * Given a number array to represent different coin denominations and a total amount ‘T’, we need to find all the
 * different ways to make a change for ‘T’ with the given coin denominations. We can assume an infinite supply of
 * coins, therefore, each coin can be chosen multiple times.
 */
public class CoinChange
{
    public int countChange(int[] denominations, int total)
    {
        if(denominations == null || denominations.length == 0 || total == 0)
        {
            return 0;
        }
        return countChange(denominations, total, 0);
    }

    public int countChange(int[] denominations, int total, int currentIndex)
    {
        if(total == 0)
        {
            return 1;
        }

        if(currentIndex >= denominations.length || total < 0)
        {
            return 0;
        }

        int count = 0;
        if(denominations[currentIndex] <= total)
        {
            count += countChange(denominations, total - denominations[currentIndex], currentIndex);
        }
        count += countChange(denominations, total, currentIndex + 1);
        return count;
    }

    public int countChangeTopDown(int[] denominations, int total)
    {
        if(denominations == null || denominations.length == 0 || total == 0)
        {
            return 0;
        }

        int[][] countMemo = new int[denominations.length][total+1];
        return countChangeTopDown(denominations, total, 0, countMemo);
    }

    public int countChangeTopDown(int[] denominations, int total, int currentIndex, int[][] countMemo)
    {
        if(total == 0)
        {
            return 1;
        }

        if(total < 0 || currentIndex >= denominations.length)
        {
            return 0;
        }

        if(countMemo[currentIndex][total] != 0)
        {
            return countMemo[currentIndex][total];
        }

        int count = 0;
        if(denominations[currentIndex] <= total)
        {
            count += countChangeTopDown(denominations, total - denominations[currentIndex], currentIndex, countMemo);
        }
        count += countChangeTopDown(denominations, total, currentIndex + 1, countMemo);
        countMemo[currentIndex][total] = count;
        return countMemo[currentIndex][total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeTopDown(denominations, 5));
    }
}
