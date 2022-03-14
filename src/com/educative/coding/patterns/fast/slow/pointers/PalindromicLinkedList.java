package com.educative.coding.patterns.fast.slow.pointers;

/**
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 * Your algorithm should use constant space and the input LinkedList should be in the original form once the
 * algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes
 * in the LinkedList.
 *
 * Example 1:
 *
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
 * Output: true
 * Example 2:
 *
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
 * Output: false
 *
 */
public class PalindromicLinkedList
{
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindromeMine(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = reverse(slow);
        ListNode temp = head;
        while(middle != null && temp != null)
        {
            if(middle.value != temp.value)
            {
                reverse(slow);
                return false;
            }
            middle = middle.next;
            temp = temp.next;
        }
        if(middle == null && temp == null)
        {
            reverse(slow);
            return true;
        }
        return false;
    }

    public static ListNode reverseMine(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindromeMine(head));

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindromeMine(head));
    }

}
