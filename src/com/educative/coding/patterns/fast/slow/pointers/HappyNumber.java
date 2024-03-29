package com.educative.coding.patterns.fast.slow.pointers;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 *
 * Example 1:
 * Input: 23
 * Output: true (23 is a happy number)
 * Explanations: Here are the steps to find out that 23 is a happy number:
 *
 * 2^2 + 3^2 = 4 + 9 = 13
 * 1^2 + 3^2 = 1 + 9 = 10
 * 1^2 + 0^2 = 1 + 0 = 1 -- Happy Number
 *
 * Example 2:
 *
 * Input: 12
 * Output: false (12 is not a happy number)
 * Explanations: Here are the steps to find out that 12 is not a happy number:
 *
 * 1^2 + 2^2 = 1 + 4 = 5
 * 5^2 = 25
 * 2^2 + 5^2 = 4 + 25 = 29
 * 2^2 + 9^2 = 4 + 81 = 85
 * 8^2 + 5^2 = 64 + 25 = 89 ***
 * 8^2 + 9^2 = 64 + 81 = 145
 * 1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42
 * 4^2 + 2^2 = 16 + 4 = 20
 * 2^2 + 0^2 = 4
 * 4^2 = 16
 * 1^2 + 6^2 = 37
 * 3^2 + 7^2 = 58
 * 5^2 + 8^2 = 89 ***
 */
public class HappyNumber
{
    public static boolean find(int num) {
        int slow = num; int fast = num;
        do {
            slow = findSquaredSum(slow);
            fast = findSquaredSum(findSquaredSum(fast));
        } while(slow != fast);

        return slow == 1;
    }

    private static int findSquaredSum(int num)
    {
        int sum = 0;
        int digit = 0;
        while(num > 0)
        {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
    }
}
