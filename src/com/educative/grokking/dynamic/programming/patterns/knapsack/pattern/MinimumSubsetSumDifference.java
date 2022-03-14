package com.educative.grokking.dynamic.programming.patterns.knapsack.pattern;

public class MinimumSubsetSumDifference
{
    public int getMinSubsetSumDifference(int[] num) {
        return getMinSubsetSumDifference(num, 0, 0, 0);
    }

    public int getMinSubsetSumDifference(int[] num, int sum1, int sum2, int currentIndex)
    {
        if(currentIndex == num.length)
        {
            return Math.abs(sum1-sum2);
        }

        int diff1 = getMinSubsetSumDifference(num, sum1+num[currentIndex], sum2, currentIndex+1);
        int diff2 = getMinSubsetSumDifference(num, sum1, sum2+num[currentIndex], currentIndex+1);

        return Math.min(diff1, diff2);
    }

    public int getMinSubsetSumDifferenceTopDown(int[] num) {
        int sum = 0;
        for(int index = 0; index < num.length; index++)
        {
            sum += num[index];
        }
        int[][] subsetSumDiff = new int[num.length][sum];
        return getMinSubsetSumDifferenceTopDown(num, 0, 0, 0, subsetSumDiff);
    }

    public int getMinSubsetSumDifferenceTopDown(int[] num, int sum1, int sum2, int currentIndex, int[][] subsetSumDiff)
    {
        if(currentIndex == num.length)
        {
            return Math.abs(sum1-sum2);
        }

        if(subsetSumDiff[currentIndex][sum1] != -1)
        {
            return subsetSumDiff[currentIndex][sum1];
        }

        int diff1 = getMinSubsetSumDifferenceTopDown(num, sum1+num[currentIndex], sum2, currentIndex+1, subsetSumDiff);
        int diff2 = getMinSubsetSumDifferenceTopDown(num, sum1, sum2+num[currentIndex], currentIndex+1, subsetSumDiff);

        subsetSumDiff[currentIndex][sum1] =  Math.min(diff1, diff2);
        return subsetSumDiff[currentIndex][sum1];
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifference minDiff = new MinimumSubsetSumDifference();
        int[] num = {1, 2, 3, 9};
        System.out.println(minDiff.getMinSubsetSumDifference(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(minDiff.getMinSubsetSumDifference(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(minDiff.getMinSubsetSumDifference(num));
    }
}
