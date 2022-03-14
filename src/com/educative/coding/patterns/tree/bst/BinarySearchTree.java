package com.educative.coding.patterns.tree.bst;

import com.educative.recursion.problems.TreeNode;

public class BinarySearchTree
{
    TreeNode root;
    public BinarySearchTree(TreeNode root)
    {
        this.root = root;
    }

    public TreeNode getRoot()
    {
        return this.root;
    }

    public void setRoot(TreeNode treeNode)
    {
        this.root = treeNode;
    }

    public boolean isEmpty()
    {
        return this.root == null;
    }

    public boolean add(int val)
    {
        if(isEmpty())
        {
            root = new TreeNode(val);
        }

        TreeNode currNode = root;
        while(currNode != null)
        {
            if(currNode.val <= val)
            {
                if(currNode.right == null)
                {
                    TreeNode rightNode = new TreeNode(val);
                    currNode.right = rightNode;
                    return true;
                }
                currNode = currNode.right;
            }
            else
            {
                if(currNode.left == null)
                {
                    TreeNode leftNode = new TreeNode(val);
                    currNode.left = leftNode;
                    return true;
                }
                currNode = currNode.left;
            }
        }
        return false;
    }

    public TreeNode insert(TreeNode root, int val)
    {
        if(root == null)
        {
            return new TreeNode(val);
        }

        if(val < root.val)
        {
            root.left = insert(root.left, val);
        }
        else if(val > root.val)
        {
            root.right =  insert(root.right, val);
        }

        return root;
    }

    public TreeNode search(int val) {
        if(isEmpty())
        {
            return null;
        }

        TreeNode currNode = this.root;
        while(currNode != null)
        {
            if(currNode.val == val)
            {
                return currNode;
            }
            if(currNode.val > val)
            {
                currNode = currNode.left;
            }
            else if(currNode.val < val)
            {
                currNode = currNode.right;
            }
        }
        return null;
    }

    public TreeNode search(TreeNode currNode, int val)
    {
        if(isEmpty())
        {
            return null;
        }
        if(val < currNode.val)
        {
            return search(currNode.left, val);
        }
        else if (val > currNode.val)
        {
            return search(currNode.right, val);
        }
        else
        {
            return currNode;
        }
    }
}
