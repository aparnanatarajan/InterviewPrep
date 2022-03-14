package com.educative.coding.patterns.two.pointers;

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int sqArrIndex = arr.length - 1;
        int leftIndex = 0;
        int rightIndex = sqArrIndex;
        while(leftIndex <= rightIndex)
        {
            if(square(arr[leftIndex]) > square(arr[rightIndex]))
            {
                squares[sqArrIndex] = square(arr[leftIndex]);
                leftIndex++;
            }
            else
            {
                squares[sqArrIndex] = square(arr[rightIndex]);
                rightIndex--;
            }
            sqArrIndex--;
        }
        return squares;
    }

    public static int square(int num)
    {
        return num * num;
    }
}
