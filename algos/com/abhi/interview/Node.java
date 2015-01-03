package com.abhi.interview;

/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 12/22/14.
 */

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    public Node( int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
