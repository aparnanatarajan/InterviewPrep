package com.educative.coding.patterns.tree.bfs;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 */
class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            int sum = 0;
            for(int i = 1; i <= queueSize; i++)
            {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left != null)
                {
                    queue.offer(temp.left);
                }
                if(temp.right != null)
                {
                    queue.offer(temp.right);
                }
            }
            Double avg = Double.valueOf((double)sum/(double)queueSize);
            result.add(avg);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}