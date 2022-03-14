package com.educative.coding.patterns.tree.bfs;
import java.util.*;

/**
 * Given a binary tree, connect each node with its level order successor. The last node of each level should point
 * to the first node of the next level.
 */
class ConnectAllSiblings {
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
                if(currNode.left != null)
                {
                    queue.offer(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.offer(currNode.right);
                }
                if(prev != null)
                {
                    prev.next = currNode;
                }
                prev = currNode;
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
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        NextTreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
