package com.educative.recursion.problems;

import java.util.Arrays;

public class InvertPositionofElements
{
    public void invertPositionOfElements(int[] a, int currIndex, int low, int high)
    {
        if(currIndex < a.length)
        {
            if(low < high)
            {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                invertPositionOfElements(a, currIndex,low+1, high-1);
            }
        }
    }

    public static void main(String args[])
    {
        int[] a = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        InvertPositionofElements i = new InvertPositionofElements();
        i.invertPositionOfElements(a, 0, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
