package com.educative.recursion.problems;

public class ReplaceNegativeIntegersWithZero
{
    public int replaceNegativesWithZero(int[] a, int currIndex)
    {
        if(currIndex == a.length)
        {
            return 0;
        }

        if(a[currIndex] < 0)
        {
            a[currIndex] = 0;
        }

        return replaceNegativesWithZero(a, currIndex+1);
    }

    public static void main(String args[])
    {
        int[] a = {2,-3,4,-1,-7,8,3};
        System.out.println("Replacing negative nums to positive");
    }
}
