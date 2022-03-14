package com.educative.coding.patterns.tree.bfs;
import java.util.*;

/**
 * Problem 1: Given a binary tree, find its maximum depth (or height).
 * Solution: We will follow a similar approach. Instead of returning as soon as we find a leaf node, we will keep
 * traversing for all the levels, incrementing maximumDepth each time we complete a level. Here is what the code
 * will look like:
 */
class MaximumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maximumTreeDepth = 0;
        while (!queue.isEmpty()) {
            maximumTreeDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

        return maximumTreeDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Maximum Depth: " + MaximumBinaryTreeDepth.findDepth(root));
    }
}
