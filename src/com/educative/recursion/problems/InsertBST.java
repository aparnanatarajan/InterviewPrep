package com.educative.recursion.problems;

public class InsertBST
{
    public TreeNode insertIntoBST(TreeNode root, int num)
    {
        if(root == null)
            return new TreeNode(num);

        if(root.val < num)
        {
            root.right = insertIntoBST(root.right, num);
        }
        else if(root.val > num)
        {
            root.left = insertIntoBST(root.left, num);
        }
        else
            return root;
    }
}
