package com.educative.recursion.problems;

public class SumNumberofElements
{
    public int sumofElementsInLL(LinkedListNode node)
    {
        if(node == null)
        {
            return 0;
        }
        return node.val + sumofElementsInLL(node.next);
    }

    public static void main(String[] args)
    {
        LinkedListNode node = new LinkedListNode(1, new LinkedListNode
                (2, new LinkedListNode(3, new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6))))));
        SumNumberofElements s = new SumNumberofElements();
        System.out.println(s.sumofElementsInLL(node));
    }
}
