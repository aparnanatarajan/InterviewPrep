package com.educative.grokking.dynamic.programming.patterns.unbounded.knapsack.pattern;

/**
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack that has a capacity ‘C’.
 * The goal is to get the maximum profit from the items in the knapsack. The only difference between the 0/1 Knapsack
 * problem and this problem is that we are allowed to use an unlimited quantity of an item.
 *
 * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the
 * weights and profits of the fruits:
 *
 * Items: { Apple, Orange, Melon }
 * Weights: { 1, 2, 3 }
 * Profits: { 15, 20, 50 }
 * Knapsack capacity: 5
 *
 * Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.
 *
 * 5 Apples (total weight 5) => 75 profit
 * 1 Apple + 2 Oranges (total weight 5) => 55 profit
 * 2 Apples + 1 Melon (total weight 5) => 80 profit
 * 1 Orange + 1 Melon (total weight 5) => 70 profit
 *
 * This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit and the total weight
 * does not exceed the capacity.
 *
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items
 * which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. We can
 * assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
 */
public class UnboundedKnapsack
{
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if(profits == null || profits.length == 0 || weights == null || weights.length == 0 ||
                profits.length != weights.length || capacity <= 0)
        {
            return 0;
        }
        return solveKnapsack(profits, weights, capacity, 0);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity, int currentIndex)
    {
        if(capacity <= 0 || currentIndex >= profits.length)
        {
            return 0;
        }

        int profitsIncl = 0;
        if(weights[currentIndex] <= capacity)
        {
            profitsIncl = profits[currentIndex] + solveKnapsack(profits, weights,
                    capacity - weights[currentIndex], currentIndex);
        }
        int profitsExcl = solveKnapsack(profits, weights, capacity, currentIndex + 1);

        return Math.max(profitsIncl, profitsExcl);
    }

    public int solveKnapsackTopDown(int[] profits, int[] weights, int capacity)
    {
        if(profits == null || profits.length == 0 || weights == null || weights.length == 0 ||
                profits.length != weights.length || capacity <= 0)
        {
            return 0;
        }

        int[][] maxProfitsMemo = new int[profits.length][capacity+1];
        return solveKnapsackTopDown(profits, weights, capacity, 0, maxProfitsMemo);
    }

    public int solveKnapsackTopDown(int[] profits, int[] weights, int capacity, int currentIndex, int[][] maxProfitsMemo)
    {
        if(capacity <= 0 || currentIndex >= profits.length)
        {
            return 0;
        }

        if(maxProfitsMemo[currentIndex][capacity] > 0)
        {
            return maxProfitsMemo[currentIndex][capacity];
        }

        int profitsIncl = 0;
        if(weights[currentIndex] <= capacity)
        {
            profitsIncl = profits[currentIndex] + solveKnapsackTopDown(profits, weights,
                    capacity - weights[currentIndex], currentIndex, maxProfitsMemo);
        }
        int profitsExcl = solveKnapsackTopDown(profits, weights, capacity, currentIndex + 1, maxProfitsMemo);
        maxProfitsMemo[currentIndex][capacity] = Math.max(profitsIncl, profitsExcl);
        return maxProfitsMemo[currentIndex][capacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsackTopDown(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
