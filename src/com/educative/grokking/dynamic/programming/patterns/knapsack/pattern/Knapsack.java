package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items
 * which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Write
 * a function that returns the maximum profit. Each item can only be selected once, which means either we put an
 * item in the knapsack or skip it.
 *
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack that has a capacity
 * ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once,
 * as we don’t have multiple quantities of any item.
 *
 * Let’s take Merry’s example, who wants to carry some fruits in the knapsack to get maximum profit. Here are the
 * weights and profits of the fruits:
 *
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 *
 * Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:
 *
 * Apple + Orange (total weight 5) => 9 profit
 * Apple + Banana (total weight 3) => 7 profit
 * Orange + Banana (total weight 4) => 8 profit
 * Banana + Melon (total weight 5) => 10 profit
 *
 * This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight
 * does not exceed the capacity.
 */
public class Knapsack
{
    public int solveKnapsack(int[] profits, int[] weights, int capacity)
    {
        return solveKnapsack(profits, weights, capacity, 0);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity, int index)
    {
        if(capacity <= 0 || index >= weights.length)
        {
            return 0;
        }
        int profitIncl = 0;
        if(weights[index] <= capacity)
        {
            profitIncl = profits[index] + solveKnapsack(profits, weights, capacity - weights[index],
                    index+1);
        }
        int profitExcl = solveKnapsack(profits, weights, capacity, index+1);

        return Math.max(profitIncl, profitExcl);
    }

    public int solveKnapsackTopDown(int[][] totalProfits, int[] profits, int[] weights, int capacity, int index)
    {
        if(capacity == 0 || index >= weights.length)
        {
            return 0;
        }
        if(totalProfits[index][capacity] != 0)
        {
            return totalProfits[index][capacity];
        }
        int profitIncl = 0;
        if(weights[index] <= capacity)
        {
            profitIncl = profits[index] + solveKnapsack(profits, weights, capacity - weights[index],
                    index+1);
        }
        int profitExcl = solveKnapsack(profits, weights, capacity, index+1);
        totalProfits[index][capacity] = Math.max(profitIncl, profitExcl);
        return totalProfits[index][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
