package com.educative.recursion.problems;

public class PrintReversedLinkedList
{
    public void printReversedLinkedList(LinkedListNode node)
    {
        if(node == null)
        {
            return;
        }

        printReversedLinkedList(node.next);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args)
    {
        LinkedListNode node = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6))))));
        PrintReversedLinkedList p = new PrintReversedLinkedList();
        p.printReversedLinkedList(node);
    }
}
