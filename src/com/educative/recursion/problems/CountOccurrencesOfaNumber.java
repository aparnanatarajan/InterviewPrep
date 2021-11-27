package com.educative.recursion.problems;

public class CountOccurrencesOfaNumber
{
    public int countNumOccurrences(int[] a, int num, int currIndex)
    {
        if(currIndex == a.length)
        {
            return 0;
        }

        if(a[currIndex] == num)
        {
            return 1 + countNumOccurrences(a, num, currIndex+1);
        }
        else
        {
            return countNumOccurrences(a, num, currIndex+1);
        }
    }

    public static void main(String args[])
    {
        int[] a = {2,3,4,1,7,8,3};
        int num = 3;
        CountOccurrencesOfaNumber c = new CountOccurrencesOfaNumber();
        System.out.println(num + " occurs " + c.countNumOccurrences(a, num, 0) + "times" );
    }
}
