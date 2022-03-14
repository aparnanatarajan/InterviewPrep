package com.educative.coding.patterns.tree.bfs;
import java.util.*;

/**
 * Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path from
 * the root node to the nearest leaf node.
 */
class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            level++;
            for(int i = 1; i <= queueSize; i++)
            {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null)
                {
                    return level;
                }
                if(temp.left != null)
                {
                    queue.offer(temp.left);
                }
                if(temp.right != null)
                {
                    queue.offer(temp.right);
                }
            }
        }

        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}