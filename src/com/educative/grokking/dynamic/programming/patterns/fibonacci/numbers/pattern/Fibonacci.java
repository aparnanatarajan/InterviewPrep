package com.educative.grokking.dynamic.programming.patterns.fibonacci.numbers.pattern;

/**
 * Write a function to calculate the nth Fibonacci number.
 *
 * Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers.
 * First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, …
 */
public class Fibonacci
{
    public int CalculateFibonacci(int n) {
        if(n <= 1)
        {
            return n;
        }

        return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
    }

    public int CalculateFibonacciTopDown(int n) {
        int dp[] = new int[n + 1];
        return CalculateFibonacciTopDown(dp, n);
    }

    public int CalculateFibonacciTopDown(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] == 0)
            dp[n] = CalculateFibonacciTopDown(dp, n - 1) + CalculateFibonacciTopDown(dp, n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
}
