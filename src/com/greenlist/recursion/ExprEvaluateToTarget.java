package com.greenlist.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given a string that contains only digits from 0 to 9, and an integer value, target. Find out how many expressions
 * are possible which evaluate to target using binary operator +, – and * in given string of digits.
 *
 * Input : "123",  Target : 6
 * Output : {“1+2+3”, “1*2*3”}
 *
 * Input : “125”, Target : 7
 * Output : {“1*2+5”, “12-5”}
 */
public class ExprEvaluateToTarget
{
    public static void main(String[] args)
    {
        List<String> result = new ArrayList<>();
        getExpressions("123", 6, "", 0, 0, 0, result);
        System.out.println(Arrays.toString(result.toArray()));

        result.clear();
        getExpressions("125", 7, "", 0, 0, 0, result);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void getExpressions(String input, int target, String currExpr, int currPos, int currVal,
                                      int lastVal, List<String> result)
    {
        if(currPos == input.length())
        {
            if(currVal == target)
            {
                result.add(currExpr);
            }
            return;
        }

        for(int index = currPos; index < input.length(); index++)
        {
            if (index != currPos && input.charAt(currPos) == '0')
                break;

            String newPart = input.substring(currPos, index+1);
            if(newPart != null && !newPart.isEmpty())
            {
                int curr = Integer.parseInt(newPart);
                if(currExpr.isEmpty())
                {
                    getExpressions(input, target, currExpr + curr, index + 1, curr, curr, result);
                }
                else
                {
                    getExpressions(input, target, currExpr + "+" + newPart, index + 1, currVal + curr, curr, result);
                    getExpressions(input, target, currExpr + "-" + newPart, index + 1, currVal - curr, -curr, result);
                    getExpressions(input, target, currExpr + "*" + newPart, index + 1, currVal - lastVal + lastVal * curr, lastVal * curr, result);
                }
            }
        }
    }
}
