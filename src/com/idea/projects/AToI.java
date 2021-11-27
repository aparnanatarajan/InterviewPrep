package com.idea.projects;

import java.util.regex.Pattern;

/**
 * Converts String to Integer without use of parseInt() method.
 */
public class AToI
{
    public static int convertStrToInt(String input)
    {
        boolean flag = false;
        if(input.charAt(0) == '-')
            flag = true;

        int num = 0;
        if(Pattern.matches("\\d+", (flag?input.substring(1):input)))
        {
            for(int i=1; i<input.length(); i++)
            {
                num = (num*10) + (input.charAt(i) - '0');
            }
        }
        else
        {
            return Integer.MAX_VALUE; // bad value not mentioned
        }
        if(flag)
            return -num;
        return num;
    }

    public static void main(String args[])
    {
        String input = "-9466";
        System.out.println(convertStrToInt(input));
    }
}
