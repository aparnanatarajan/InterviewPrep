package com.educative.grokking.dynamic.programming.patterns.unbounded.knapsack.pattern;

/**
 * Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
 * We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
 *
 * Example:
 *
 * Lengths: [1, 2, 3, 4, 5]
 * Prices: [2, 6, 7, 10, 13]
 * Rod Length: 5
 *
 * Let’s try different combinations of cutting the rod:
 *
 * Five pieces of length 1 => 10 price
 * Two pieces of length 2 and one piece of length 1 => 14 price
 * One piece of length 3 and two pieces of length 1 => 11 price
 * One piece of length 3 and one piece of length 2 => 13 price
 * One piece of length 4 and one piece of length 1 => 12 price
 * One piece of length 5 => 13 price
 *
 * This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of
 * length ‘1’.
 */
public class RodCutting
{
    public int solveRodCutting(int[] lengths, int[] prices, int n)
    {
        if(prices == null || prices.length == 0 || lengths == null || lengths.length == 0 || prices.length != lengths.length || n == 0)
        {
            return 0;
        }
        return solveRodCutting(lengths, prices, n, 0);
    }

    public int solveRodCutting(int[] lengths, int[] prices, int n, int currentIndex)
    {
        if(n == 0 || currentIndex >= prices.length)
        {
            return 0;
        }

        int profitIncl = 0;
        if(lengths[currentIndex] <= n)
        {
            profitIncl = prices[currentIndex] + solveRodCutting(lengths, prices, n - lengths[currentIndex], currentIndex);
        }

        int profitExcl = solveRodCutting(lengths, prices, n, currentIndex + 1);
        return Math.max(profitIncl, profitExcl);
    }

    public static void main(String[] args)
    {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}
