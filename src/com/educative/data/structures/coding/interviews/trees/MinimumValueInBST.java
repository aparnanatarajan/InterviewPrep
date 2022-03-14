package com.educative.data.structures.coding.interviews.trees;

public class MinimumValueInBST
{
    public static int findMin(Node root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        if(root.getLeft() != null)
            return findMin(root.getLeft());
        else
            return root.getData();
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println("Min Value in BST: " + findMin(bsT.getRoot()));

    }

}
