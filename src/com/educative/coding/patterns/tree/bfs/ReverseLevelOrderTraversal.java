package com.educative.coding.patterns.tree.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest
 * level comes first. You should populate the values of all nodes in each level from left to right in separate
 * sub-arrays.
 */
public class ReverseLevelOrderTraversal
{
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i = 1; i <= queueSize; i++)
            {
                TreeNode temp = queue.poll();
                levelNodes.add(temp.val);
                if(temp.left != null)
                {
                    queue.offer(temp.left);
                }
                if(temp.right != null)
                {
                    queue.offer(temp.right);
                }
            }
            result.add(0, levelNodes);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
