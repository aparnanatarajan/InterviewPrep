package com.educative.recursion.problems;

/**
 * Given a linked list, access each node in such a way so that the linked list will print in a reversed manner.
 * You may not change the content of the list.
 *
 */
public class LinkedListNode
{
    public int val;
    public LinkedListNode next;

    public LinkedListNode(int val)
    {
        this.val = val;
        next = null;
    }

    public LinkedListNode(int val, LinkedListNode node)
    {
        this.val = val;
        this.next = node;
    }
}
