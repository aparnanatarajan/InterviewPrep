package com.educative.coding.patterns.inplace.reverse.linked.list;

class ListNode
{
    int value = 0;
    ListNode next;

    ListNode(int value)
    {
        this.value = value;
    }
}

class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k)
    {
        int count = 1;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null)
        {
            curr = curr.next;
            count++;
            if (count == k - 1) {
                System.out.println("count " + count);
                if (curr != null)
                    System.out.println("curr node " + curr.value);
                count = 1;
            }
        }
        return head;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}