package com.educative.coding.patterns.tree.bfs;

import java.util.*;

class NextTreeNode {
    int val;
    NextTreeNode left;
    NextTreeNode right;
    NextTreeNode next;

    NextTreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        NextTreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            NextTreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}

class ConnectLevelOrderSiblings {
    public static void connect(NextTreeNode root)
    {
        Queue<NextTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        NextTreeNode prev = null;
        while(!queue.isEmpty())
        {
            int queueSize = queue.size();
            for(int i = 1; i <= queueSize; i++)
            {
                NextTreeNode currNode = queue.poll();
                if(prev != null)
                {
                    prev.next = currNode;
                }
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
                    currNode.next = null;
                    prev = null;
                }
                else
                {
                    prev = currNode;
                }
            }
        }
    }

    public static void main(String[] args) {
        NextTreeNode root = new NextTreeNode(12);
        root.left = new NextTreeNode(7);
        root.right = new NextTreeNode(1);
        root.left.left = new NextTreeNode(9);
        root.right.left = new NextTreeNode(10);
        root.right.right = new NextTreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}

