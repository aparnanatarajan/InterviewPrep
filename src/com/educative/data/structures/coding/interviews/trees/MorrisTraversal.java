package com.educative.data.structures.coding.interviews.trees;

public class MorrisTraversal {

    public void inorder(Node root) {
        Node current = root;
        while(current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.getData() + " ");
                current = current.right;
            }
            else {
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{ //left is already visit. Go rigth after visiting current.
                    predecessor.right = null;
                    System.out.print(current.getData() + " ");
                    current = current.right;
                }
            }
        }
    }

    public void preorder(Node root) {
        Node current = root;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.getData() + " ");
                current = current.right;
            }
            else {
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.getData() + " ");
                    current = current.left;
                }else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bt = new BinarySearchTree();
        Node root = null;
        bt.add(10);
        bt.add(50);
        bt.add(-10);
        bt.add(7);
        bt.add(9);
        bt.add(-20);
        bt.add(30);
        MorrisTraversal mt = new MorrisTraversal();
        mt.inorder(root);
        System.out.println();
        mt.preorder(root);
    }
}
