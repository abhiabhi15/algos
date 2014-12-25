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

    Node( int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class BSTree {

    Node root;

    public Node insert(Node node, int num){

        if(node == null){
            return new Node(num, null, null);
        }
        if(node.data >= num){
            node.left = insert(node.left, num);
        }else{
            node.right = insert(node.right, num);
        }
        return node;
    }

    public void preorderTraversal(Node node){
        if(node == null) return;

        System.out.print(node.data + "  ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void inorderTraversal(Node node){
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public void postorderTraversal(Node node){
        if( node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + "   ");
    }

    public int height(Node node){

        if( node == null) return 0;
        int left = height(node.left) + 1;
        int right = height(node.right) + 1;
        return Math.max(left, right);
    }

    public void levelorderTraversal( Node node){
        int height = height(node);
        for(int level = 1;  level <= height; level++){
            printLevel(node, level);
            System.out.println();
        }
    }

    public void printLevel(Node node, int level){
        if(node == null) return;
        if( level == 1){
            System.out.print(node.data + "  ");
        }else{
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    public int size(Node node){
        if(node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }

    public boolean identical(Node node1, Node node2){
        if( node1 == null && node2 == null){
            return true;
        }
        return (node1.data == node2.data)  && identical(node1.left, node2.left) &&
                identical(node1.right, node2.right);
    }

    public int leafCount(Node node){
        if(node == null) return 0;
        int leaves = leafCount(node.left) + leafCount(node.right);
        return (leaves == 0) ? 1 : leaves;
    }

    public void printPaths(Node node){
        int[] path = new int[100];
        printPaths(node, path, 0);
    }

    public void printPaths(Node node, int[] path, int len){
        if(node == null) return;
        path[len++] = node.data;
        if(node.left == null && node.right == null){
            for(int i = 0; i < len; i++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }else{
            printPaths(node.left, path, len);
            printPaths(node.right, path, len);
        }
    }

    public Node deleteTree( Node node){
        if(node == null ) return null;
        deleteTree(node.left);
        deleteTree(node.right);
        System.out.println("Deleting node " + node.data);
        node.left = null;
        node.right = null;
        return null;
    }

    public Node mirrorTree( Node node){
        if(node == null ) return null;
        Node newNode = new Node(node.data, null, null);
        newNode.left = mirrorTree(node.right);
        newNode.right = mirrorTree(node.left);
        return newNode;
    }

    public boolean search(Node node, int x){
        if(node == null)  return false;
        if(node.data == x) return true;
        if(node.data > x){
            return search(node.left, x);
        }else{
            return search(node.right, x);
        }
    }

    public Node leastCommonAncestor(Node node, int n1, int n2){
        if(node == null) return null;
        if( !search(node, n1) || !search(node, n2)){
            return null;
        }
        if(node.data > n1 && node.data > n2) {
            return leastCommonAncestor(node.left, n1, n2);
        }
        if( node.data < n1 && node.data < n2){
            return leastCommonAncestor(node.right, n1, n2);
        }
        return node;
    }

    public int minVal(Node node){
        if(node.left != null){
            return minVal(node.left);
        }
        return node.data;
    }

    static Node prev = null;
    public boolean isBST(Node node){

        if(node == null ) return true;
        if(!isBST(node.left)){
            return false;
        }
        if( prev != null && node.data < prev.data){
            return false;
        }
        prev = node;

        return isBST(node.right);
    }

    //For Binary Tree, the parent node data = sum of child nodes data
    public boolean childSum(Node node){
        if( node == null || ( node.left == null && node.right == null)){
            return true;
        }
        int left = 0, right = 0;
        if(node.left != null){
            left = node.left.data;
        }
        if( node.right != null){
            right = node.right.data;
        }

        return (node.data == (left+right)) && childSum(node.left) && childSum(node.right);
    }

    public void spiralOrderTraversal(Node node){

        int height = height(node);
        boolean turn = true;
        for(int level = 1; level <= height; level++){
            printSpiralLevel(node, level, turn);
            turn = !turn;
            System.out.println();
        }
    }


    private void printSpiralLevel(  Node node, int level, boolean turn){
        if(node == null) return;
        if(level == 1){
            System.out.print(node.data + "  ");
        }else{
            if(turn){
                printSpiralLevel(node.left, level-1, turn);
                printSpiralLevel(node.right, level-1, turn);
            }else{
                printSpiralLevel(node.right, level-1, turn);
                printSpiralLevel(node.left, level-1, turn);

            }
        }
    }

    private int getDiameterHelper(Node node, HeightWrapper wrapper){

        if(node == null){
            return 0;
        }
        HeightWrapper lwrapper = new HeightWrapper();
        HeightWrapper rwrapper = new HeightWrapper();

        int ldiameter = getDiameterHelper(node.left, lwrapper);
        int rdiameter = getDiameterHelper(node.right, rwrapper);

        //Root Diameter
        int rootDiameter = lwrapper.height + rwrapper.height + 1;

        //Current height
        wrapper.height = Math.max(lwrapper.height, rwrapper.height) + 1;

        return Math.max( rootDiameter, Math.max(ldiameter, rdiameter));
    }

    public int getDiameter(Node node){
        HeightWrapper wrapper = new HeightWrapper();
        return getDiameterHelper(node, wrapper);
    }

    public boolean hasPathSum(Node node, int sum){
        if(node  == null) {
            return false;
        }
        if(node.left == null && node.right == null){
            return ((sum - node.data) == 0);
        }
        return (hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data));
    }

    public int maxwidth( Node node){

        int height = height(node);
        int max = 0;
        for(int level = 1; level <=height; level++){
            int curr_max = getLevelWidth(node, level);
            if(curr_max > max){
                max = curr_max;
            }
        }
        return max;
    }

    private int getLevelWidth(Node node, int level){

        if(node == null) {
            return 0;
        }

        if(level == 1){
            return 1;
        }else{
            return getLevelWidth(node.left, level-1) + getLevelWidth(node.right, level-1);
        }
    }

    public Node childSumTree(Node node){
        if(node == null)  return null;
        if(node.left == null && node.right == null){
            return node;
        }
        node.left = childSumTree(node.left);
        node.right = childSumTree(node.right);
        int left = 0,right=0;
        if(node.left != null){
           left = node.left.data;
        }
        if(node.right != null){
            right = node.right.data;
        }
        node.data = left + right;
        return node;
    }

    public boolean isBalancedTree(Node node){
        if(node == null ) return true;
        int left = height(node.left);
        int right = height(node.right);
        if( Math.abs(left -right) > 1){
            return false;
        }else{
            return isBalancedTree(node.left) && isBalancedTree(node.right);
        }
    }

    public static void main(String[] args) {

        BSTree bsTree = new BSTree();
        bsTree.root = bsTree.insert(bsTree.root, 23);
        bsTree.insert(bsTree.root, 8);bsTree.insert(bsTree.root, 24);
    //    bsTree.insert(bsTree.root, 6);bsTree.insert(bsTree.root, 10);bsTree.insert(bsTree.root, 16);
   //     bsTree.insert(bsTree.root, 3);bsTree.insert(bsTree.root, 7);bsTree.insert(bsTree.root, 12);bsTree.insert(bsTree.root, 18);

        bsTree.levelorderTraversal(bsTree.root);
        System.out.println();
        System.out.println(bsTree.isBalancedTree(bsTree.root));
  //      System.out.println(bsTree.maxwidth(bsTree.root));
  //      bsTree.spiralOrderTraversal(bsTree.root);
  //      bsTree.printLevel(bsTree.root, 1);

/*
        Node lca = bsTree.leastCommonAncestor(bsTree.root, 11, 5);
        if(lca != null){
            System.out.println("LCA " + lca.data);
        }else{
            System.out.println("No LCA found");
        }
*/
       // System.out.println(bsTree.search(bsTree.root, 8));
        //Node mirror = bsTree.mirrorTree(bsTree.root);
        //bsTree.levelorderTraversal(mirror);

        //bsTree.printPaths(bsTree.root);
        //System.out.println(bsTree.leafCount(bsTree.root));
        /*BSTree bsTree1 = new BSTree();
        bsTree1.root = bsTree1.insert(bsTree1.root, 5);
        bsTree1.insert(bsTree1.root, 8);bsTree1.insert(bsTree1.root, 1);
        bsTree1.insert(bsTree1.root, 0);bsTree1.insert(bsTree1.root, 1);bsTree1.insert(bsTree1.root, -1);

        System.out.println(bsTree.identical(bsTree.root, bsTree1.root));
*/
        //System.out.println(bsTree.height(bsTree.root));
    }
}

class HeightWrapper{
        int height = 0;
}
