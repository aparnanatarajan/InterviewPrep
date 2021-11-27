package com.leetcode.problems.medium;

import com.leetcode.problems.ListNode;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * ex:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumList = new ListNode();
        ListNode temp = sumList;
        while(l1 != null || l2 != null)
        {
            int l1val = 0;
            int l2val = 0;
            if(l1 != null)
            {
                l1val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2val = l2.val;
                l2 = l2.next;
            }
            int tempSum = l1val + l2val + carry;

            carry = tempSum / 10;
            tempSum = tempSum % 10;

            temp.next = new ListNode(tempSum);
            temp = temp.next;
        }
        if(carry > 0)
        {
            temp.next = new ListNode(carry);
        }

        return sumList.next;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode result = addTwoNumbers(l1, l2);
        while(result != null)
        {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
