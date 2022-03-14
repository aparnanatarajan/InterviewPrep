package com.educative.data.structures.coding.interviews.trees;

class Node
{
    //Variables
    private  int data;
    Node left;
    Node right;

    //Constructor
    Node(int value){
        this.data=value;
        left =null;
        right =null;
    }

    //Getter-Setter
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public int  getData(){return data;}
    public void setData(int value){this.data=value;}
    public void setLeft(Node left){this.left =left;}
    public void setRight(Node right){this.right =right;}
}
