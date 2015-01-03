package com.abhi.interview;

import com.abhi.temp.problem2;

/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 1/2/15.
 */

public class TreeList {

    /*
    helper function -- given two list nodes, join them
    together so the second immediately follow the first.
    Sets the .next of the first and the .previous of the second.
   */
    public static void join(Node a, Node b){
        a.right = b;
        b.left = a;
    }

    /*
    helper function -- given two circular doubly linked
    lists, append them and return the new list.
   */
    public static Node append(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;

        Node aLast = a.left;
        Node bLast = b.left;

        join(aLast, b);
        join(bLast, a);
        return a;
    }

    /*
    --Recursion--
    Given an ordered binary tree, recursively change it into
    a circular doubly linked list which is returned.
   */
    public static Node treeToList(Node root){

        if(root == null) return null;

        Node aList = treeToList(root.left);
        Node bList = treeToList(root.right);

        root.left = root;
        root.right = root;

        aList = append(aList, root);
        aList = append(aList, bList);

        return aList;
    }

    /*
         Given a non-empty tree, insert a new node in the proper
         place. The tree must be non-empty because Java's lack
         of reference variables makes that case and this
         method messier than they should be.
        */
    public static void treeInsert(Node root, int newData) {

      if(newData <= root.data){
            if(root.left != null){
                treeInsert(root.left, newData);
            }else {
                root.left = new Node(newData);
            }
      }else {
            if(root.right != null){
                treeInsert(root.right, newData);
            }else {
                root.right = new Node(newData);
            }
      }
    }

    public static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.data + "  ");
        printTree(root.right);
    }

    public static void printList(Node head){

        Node current = head;
        while(current != null){
            System.out.print(current.data + "  ");
            current = current.right;
            if(current == head) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(4);
        treeInsert(root,2);
        treeInsert(root,1);
        treeInsert(root,3);
        treeInsert(root,5);

        System.out.println("tree :");
        printTree(root);

        System.out.println("\nlist :");
        Node head = treeToList(root);
        printList(head);
    }


}
