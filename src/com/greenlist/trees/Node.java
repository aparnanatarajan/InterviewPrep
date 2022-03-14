package com.greenlist.trees;

public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
