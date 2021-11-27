package com.educative.recursion.problems;

public class StringPalindromeCheck
{
    public static boolean checkPalindrome(String input, int currIndex)
    {
        if(currIndex >= input.length()-currIndex-1)
        {
            return true;
        }

        if(input.charAt(currIndex) == input.charAt(input.length()-currIndex-1))
        {
            return checkPalindrome(input, currIndex+1);
        }
        return false;
    }

    public static void main(String args[])
    {
        String input = "madam i'm adam";
        System.out.print(checkPalindrome(input.replaceAll("\\W+", ""), 0));
    }
}
