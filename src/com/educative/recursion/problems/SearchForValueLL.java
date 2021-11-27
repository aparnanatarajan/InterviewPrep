package com.educative.recursion.problems;

public class SearchForValueLL
{
    public boolean searchForNumberinLL(int num, LinkedListNode head)
    {
        if(head == null)
        {
            return false;
        }

        if(head.val == num)
            return true;

        return searchForNumberinLL(num, head.next);
    }

    public static void main(String[] args)
    {
        LinkedListNode node = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6))))));
        SearchForValueLL sear = new SearchForValueLL();
        System.out.println(sear.searchForNumberinLL(5, node));
    }
}
