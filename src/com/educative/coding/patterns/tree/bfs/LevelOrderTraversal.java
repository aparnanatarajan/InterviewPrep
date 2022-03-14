package com.educative.coding.patterns.tree.bfs;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of
 * all nodes of each level from left to right in separate sub-arrays.
 */
public class LevelOrderTraversal
{
    public static List<List<Integer>> traverse(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> levelNodes = new ArrayList<>();
            int queueSize = queue.size();
            for(int index = 0; index < queueSize; index++)
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
            result.add(levelNodes);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
