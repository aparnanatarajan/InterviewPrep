package com.educative.recursion.problems;

/**
 *
 * When given an array, find the first occurrence of a given number in that array and return the index of that number.
 *
 * Ex:1
 * a = {2,3,4,1,7,8,3};
 * num = 3
 * returns 1
 *
 */
public class FirstOccurrenceOfaNumber
{
    public int getFirstOccurrence(int[] a, int num, int currIndex)
    {
        if(currIndex == a.length)
        {
            return -1;
        }

        if(a[currIndex] == num)
        {
            return currIndex;
        }
        else
        {
            return getFirstOccurrence(a, num, currIndex+1);
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5,6,7,2,4,1,2,1,9,0,3,2,2};
        int num = 2;
        FirstOccurrenceOfaNumber f = new FirstOccurrenceOfaNumber();
        System.out.println("First occurrence of " + num + " = " + f.getFirstOccurrence(a, num, 0));
    }
}
