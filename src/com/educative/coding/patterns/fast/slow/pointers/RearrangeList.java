package com.educative.coding.patterns.fast.slow.pointers;

class RearrangeList {
    public static void reorder(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode foo = head;
        ListNode temp = head;
        while(temp.next != slow)
        {
            temp = temp.next;
        }
        ListNode middle = reverseLL(slow);

        while(middle != null && foo != temp)
        {
            ListNode newNode = foo.next;
            foo.next = middle;
            middle = middle.next;
            temp.next = middle;
            foo.next.next = newNode;
            foo = foo.next.next;
        }
    }

    public static ListNode reverseLL(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
