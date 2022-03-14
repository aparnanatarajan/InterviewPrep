package com.greenlist.trees;

/**
 * Given a binary tree, print out all of its root-to-leaf paths one per
 * line.
 * e.g. for a tree that's
 * 1
 * 2 3
 * 4 5 6 7
 * Print:
 * 1 2 4
 * 1 2 5
 * 1 3 6
 * 1 3 7
 */
public class PrintPaths
{
    public static void main(String[] args)
    {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        printPaths(root, "");
    }

    public static void printPaths(Node root, String currPath)
    {
        if(root == null)
        {
            return;
        }

        currPath += " " + root.val;
        printPaths(root.left, currPath);
        printPaths(root.right, currPath);
        if(root.left == null && root.right == null)
        {
            System.out.println(currPath);
        }
    }
}
