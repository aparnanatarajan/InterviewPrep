package com.educative.recursion.problems;

public class ArrayPalindromeCheck
{
    public boolean checkPalindrome(int[] a, int left, int right)
    {
        if(left >= right)
        {
            return true;
        }

        if(left < right && a[left] == a[right])
        {
            return checkPalindrome(a, left + 1, right - 1);
        }
        return false;
    }

    public boolean checkPalindrome(int[] a, int index)
    {
        if(index > a.length/2)
        {
            return true;
        }

        if(index <= a.length/2 && a[index] == a[a.length-index-1])
        {
            return checkPalindrome(a, index + 1);
        }
        return false;
    }

    public static void main(String[] args)
    {
//        int[] a = {1,2,3,4,5};
//        int[] a = {1,2,2,1};
//        int[] a = {1,2,3,7,3,2,1};
        int[] a = {0,0,1,0};
        ArrayPalindromeCheck p = new ArrayPalindromeCheck();
        System.out.println(p.checkPalindrome(a, 0, a.length-1));
        System.out.println(p.checkPalindrome(a, 0));
    }

}

