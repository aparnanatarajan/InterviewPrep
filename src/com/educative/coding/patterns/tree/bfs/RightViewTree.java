package com.educative.coding.patterns.tree.bfs;
import java.util.*;

/**
 * Given a binary tree, return an array containing nodes in its right view. The right view of a binary tree is the set
 * of nodes visible when the tree is seen from the right side.
 *
 * Similar Problem:
 * Problem 1: Given a binary tree, return an array containing nodes in its left view. The left view of a binary tree
 * is the set of nodes visible when the tree is seen from the left side.
 *
 * Solution: We will be following a similar approach, but instead of appending the last element of each level, we will
 * be appending the first element of each level to the output array.
 */
public class RightViewTree
{
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            for(int i = 1; i <= queueSize; i++)
            {
                TreeNode currNode = queue.poll();
                if(currNode.left != null)
                {
                    queue.offer(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.offer(currNode.right);
                }
                if(i == queueSize)
                {
                    result.add(currNode);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
