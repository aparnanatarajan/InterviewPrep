package com.educative.data.structures.coding.interviews.trees;

class CheckKthMax
{
    static int counter = 0;
    public static int findKthMax(Node root, int k)
    {
        Node currNode = findKthMaxNodeRec(root, k);
        if(currNode != null)
            return currNode.getData();
        return -1;
    }

    public static Node findKthMaxNodeRec(Node root, int k)
    {
        if(root == null)
        {
            return null;
        }
        Node temp = findKthMaxNodeRec(root.getRight(), k);
        if(counter != k)
        {
            counter++;
            temp = root;
        }
        if(counter == k)
        {
            return temp;
        }
        else
        {
            return findKthMaxNodeRec(root.getLeft(), k);
        }
    }

    /*public static int findKthMaxInorder (Node root, int k) {

        //Perform In-Order Traversal to get sorted array. (ascending order)
        //Return value at index [length - k]
        StringBuilder result = new StringBuilder(); //StringBuilder is mutable
        result = inOrderTraversal(root, result);

        String[] array = result.toString().split(","); //Spliting String into array of strings
        if ((array.length - k) >= 0) return Integer.parseInt(array[array.length - k]);

        return - 1;
    }

    //Helper recursive function to traverse tree using inorder traversal
    //and return result in StringBuilder
    public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {

        if (root.getLeftChild() != null) inOrderTraversal(root.getLeftChild(), result);

        result.append(root.getData() + ",");

        if (root.getRightChild() != null) inOrderTraversal(root.getRightChild(), result);

        return result;
    }*/

    public static void main(String args[])
    {
        BinarySearchTree bsT = new BinarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        System.out.println(findKthMax(bsT.getRoot(),3));
    }
}