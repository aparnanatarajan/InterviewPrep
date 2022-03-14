package com.educative.grokking.dynamic.programming.patterns.unbounded.knapsack.pattern;

/**
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. We need to cut the ribbon into the
 * maximum number of pieces that comply with the above-mentioned possible lengths. Write a method that will return
 * the count of pieces.
 *
 * Example 1:
 *
 * n: 5
 * Ribbon Lengths: {2,3,5}
 * Output: 2
 * Explanation: Ribbon pieces will be {2,3}.
 * Example 2:
 *
 * n: 7
 * Ribbon Lengths: {2,3}
 * Output: 3
 * Explanation: Ribbon pieces will be {2,2,3}.
 * Example 3:
 *
 * n: 13
 * Ribbon Lengths: {3,5,7}
 * Output: 3
 * Explanation: Ribbon pieces will be {3,3,7}.
 *
 * Given a number array to represent possible ribbon lengths and a total ribbon length ‘n,’ we need to find the
 * maximum number of pieces that the ribbon can be cut into.
 */
public class MaximumRibbonCut
{
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        if(ribbonLengths == null || ribbonLengths.length == 0 || total == 0)
        {
            return 0;
        }
        int maxLengths =  countRibbonPieces(ribbonLengths, total, 0);
        return (maxLengths == Integer.MIN_VALUE? 0: maxLengths);
    }

    public int countRibbonPieces(int[] ribbonLengths, int total, int currentIndex)
    {
        if(total == 0)
        {
            return 0;
        }

        if(total < 0 || currentIndex >= ribbonLengths.length)
        {
            return Integer.MIN_VALUE;
        }
        int countIncl = Integer.MIN_VALUE;
        if(ribbonLengths[currentIndex] <= total)
        {
            int tempCount = countRibbonPieces(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
            if(tempCount != Integer.MIN_VALUE)
                countIncl = 1 + tempCount;
        }
        int countExcl = countRibbonPieces(ribbonLengths, total, currentIndex + 1);
        return Math.max(countIncl, countExcl);
    }

    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
