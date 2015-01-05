package com.abhi.tree;


/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 1/3/15.
 */

class RNode{
    int key;
    int value;
    RNode left, right;
    boolean color;

    RNode(int key, int value, RNode left, RNode right, boolean color) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }
}

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(RNode node){
        if(node == null) return false;
        return node.color == RED;

    }

    public static void main(String[] args) {
    }
}
