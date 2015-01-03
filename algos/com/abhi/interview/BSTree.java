package com.abhi.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree {

    Node root;

    public Node insert(Node node, int num){

        if(node == null){
            return new Node(num);
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

    public Node deleteTree(Node node){
        if(node == null ) return null;
        deleteTree(node.left);
        deleteTree(node.right);
        System.out.println("Deleting node " + node.data);
        node.left = null;
        node.right = null;
        return null;
    }

    public Node mirrorTree(Node node){
        if(node == null) return null;
        Node newNode = new Node(node.data);
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

    public int getDiameter(Node node){
        HeightWrapper wrapper = new HeightWrapper();
        return getDiameterHelper(node, wrapper);
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

    public boolean hasPathSum(Node node, int sum){
        if(node  == null) {
            return false;
        }
        if(node.left == null && node.right == null){
            return ((sum - node.data) == 0);
        }
        return (hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data));
    }

    /*
    Given a binary tree, write a function to get the maximum width of the given tree.
    Width of a tree is maximum of widths of all levels
     */
    public int maxLevelwidth( Node node){

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

    //Method 2 : Using PreOrderTraversal
    public int getMaxWidthPreOrder(Node node){

        if(node == null) return 0;
        int levels = height(node);
        int[] count = new int[levels];
        maxWidthHelper(node, count, 0);
        return getMax(count);
    }

    private void maxWidthHelper(Node node, int[] count, int level){

        if(node != null){
            count[level]++;
            maxWidthHelper(node.left, count, level+1);
            maxWidthHelper(node.right, count, level+1);
        }
    }

    private int getMax(int[] arr){

        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
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

    /*
        The leafs height difference must not be greater than 1
     */
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

    public void inorderTraversalWithoutRecursion(Node node){

        if(node == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        Node current = node;
        while(!stack.isEmpty()){
            while(current.left != null){
                stack.push(current.left);
                current = current.left;
            }
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null){
                current = temp.right;
                stack.push(current);
            }
        }
    }

    public void printLevelOrderUsingQ(Node node){
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr.data + "  ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }

    /*
    Build a tree from an inorder and pre-order sequence
     */
    static int preIndex = 0;
    public Node buildTree(int[] inOrder, int[] preOrder){
        return buildTree(inOrder, preOrder, 0, preOrder.length-1);
    }

    private Node buildTree(int[] inOrder, int[] preOrder, int inStart, int inEnd){

        if(inStart > inEnd) return null;
        int num = preOrder[preIndex++];
        Node node = new Node(num);
        int rootIndex = getRootIndex(inOrder, num, inStart, inEnd);
        node.left = buildTree(inOrder, preOrder, inStart , rootIndex-1);
        node.right = buildTree(inOrder, preOrder, rootIndex+1 , inEnd);
        return node;
    }

    private int getRootIndex(int[] inOrder, int num, int inStart, int inEnd ){
        for(int i = inStart; i <= inEnd; i++){
            if(inOrder[i] == num){
                return i;
            }
        }
        return -1;
    }

    /*
      To create Double tree of the given tree, create a new duplicate for each node,
      and insert the duplicate as the left child of the original node.
     */
    public void getDoubleTree(Node node){

        if(node == null)  return;

        getDoubleTree(node.left);
        getDoubleTree(node.right);

        Node oldLeft = node.left;
        node.left = new Node(node.data);
        node.left.left = oldLeft;
    }

    /*
        In Binary Tree, Inorder successor of a node is the next node
        in Inorder traversal of the Binary Tree
     */
    public Node inorderSuccessor(Node root, Node node){

        if(node.right != null){
            return minValueNode(node.right);
        }

        Node succ = null;
        while(root != null){
            if(node.data < root.data){
                succ = root;
                root = root.left;
            }else if(node.data > root.data){
                root = root.right;
            }else{
                break;
            }
        }
        return succ;
    }

    private Node minValueNode(Node node){

        if(node.left != null){
            minValueNode(node.left);
        }
        return node;
    }

    /*
        Given a Binary Tree and a key, a function that returns level of the key.
     */
    public int getNodeLevel(Node node, int num){
        return getNodeLevelUtil(node, num, 1);
    }

    private int getNodeLevelUtil(Node node, int num, int level){

        if(node == null){
            return 0;
        }
        if(node.data == num){
            return  level;
        }
        int leftLevel = getNodeLevelUtil(node.left, num, level+1);
        if(leftLevel != 0){
            return leftLevel;
        }
        return getNodeLevelUtil(node.right, num, level+1);
    }

    public boolean printAncestors(Node node, int num){

        if(node == null){
            return false;
        }

        if(node.data == num){
            return true;
        }

        if(printAncestors(node.left, num) || printAncestors(node.right, num)){
            System.out.print(node.data + "  ");
            return true;
        }
        return false;
    }

    /*
    Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
     Print all the keys of tree in range k1 to k2.
     */
    public void printKeysInRange(Node node, int key1, int key2){

        if(node == null) return;
        if(key1 < node.data){
            printKeysInRange(node.left, key1, key2);
        }

        if(node.data >= key1 && node.data <= key2){
            System.out.print(node.data + "  ");
        }

        if(key2 > node.data){
            printKeysInRange(node.right, key1, key2);
        }
    }

    public static void main(String[] args) throws Exception{

        BSTree bsTree = new BSTree();
        bsTree.root = bsTree.insert(bsTree.root, 23);
        bsTree.insert(bsTree.root, 8);bsTree.insert(bsTree.root, 24);

        bsTree.insert(bsTree.root, 6);bsTree.insert(bsTree.root, 10);bsTree.insert(bsTree.root, 16);
        bsTree.insert(bsTree.root, 3);bsTree.insert(bsTree.root, 7);bsTree.insert(bsTree.root, 12);bsTree.insert(bsTree.root, 18);
        bsTree.levelorderTraversal(bsTree.root);

        System.out.println();
        bsTree.printKeysInRange(bsTree.root, 9, 16);
     //   bsTree.printAncestors(bsTree.root, 12);

     //   System.out.println(bsTree.getNodeLevel(bsTree.root, 7));
        /*int[] in = {4,2,5,1,6,3};
        int[] pre = {1,2,4,5,3,6};
        bsTree.root = bsTree.buildTree(in,pre);
*/
        //Node succ = bsTree.inorderSuccessor(bsTree.root, bsTree.root.left.left.left);
        //System.out.println(succ.data);
        //Node node = bsTree.childSumTree(bsTree.root);

        //bsTree.getDoubleTree(bsTree.root);
        //bsTree.levelorderTraversal(bsTree.root);
        //System.out.println(bsTree.getMaxWidthPreOrder(bsTree.root));
        //bsTree.levelorderTraversal(node);
    //    System.out.println();
        //System.out.println(bsTree.isBalancedTree(bsTree.root));
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

