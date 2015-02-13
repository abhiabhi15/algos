package com.abhi.tree;

import com.abhi.utils.InputNumbers;

class Node {

    Integer data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", left=" + left + ", right=" + right
                + "]";
    }
}

public class BSTree {

	Node root;
	
	Node insert(Node node, int num){
		if(node == null){
			return new Node(num,null,null);
		}
		if(num <= node.data){
		   node.left = insert(node.left, num);	
		}else{
		   node.right = insert(node.right, num);
		}
		return node;
	}
	
	void levelOrderTraversal(Node node){
	
		int height = maxHeight(node);
		for(int level = 1; level <= height; level++){
			printLevel(node,level);
			System.out.println();
		}
		
	}
	
	private void printLevel(Node node, int level) {
		if(node == null){
			return;
		}
		if(level == 1){
			System.out.print(" " + node.data);
		}else{
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}

	void inOrderTraversal(Node node){
		if(node == null){
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(" " + node.data + " ");
		inOrderTraversal(node.right);
	}

	void preOrderTraversal(Node node){
		if(node == null){
			return;
		}
		System.out.print(" " + node.data + " ");	
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	void postOrderTraversal(Node node){
		if(node == null){
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(" " + node.data + " ");
	}
	
	public int maxHeight(Node node){
		if(node == null){
			return 0;
		}
		int h1 = maxHeight(node.left) + 1;
		int h2 = maxHeight(node.right) + 1;
		return Math.max(h1, h2);
	}

	public boolean search(Node node,int num){
		if(node == null){
			return false;
		}
		if(node.data == num){
			return true;
		}
		if(num < node.data){
			return search(node.left,num);
		}else{
			return search(node.right,num);
		}
	}
	
	public int size(Node node){
		if(node == null){
			return 0;
		}
		int leftSize = size(node.left);
		int rightSize = size(node.right);
		return leftSize + rightSize + 1;
	}
	
	public int minValue(Node node){
		
		if(node.left == null){
			return node.data;
		}else{
			return minValue(node.left);
		}
	}
	
	public void printPaths(Node node){
		Integer path[] = new Integer[100];
		printPathRecur(node,path,0);
	}
	
	public boolean hasPathSums(Node node, int sum){
	
		if(node == null){
			return (sum == 0);
		}
		int subSum = sum - node.data;
		return hasPathSums(node.left, subSum) || hasPathSums(node.right, subSum);
	}
	
	private void printPathRecur(Node node, Integer[] path, int len) {
		
		if(node == null){
			return;
		}
		path[len++] = node.data;
		if(node.left == null && node.right == null){
			InputNumbers.printArray(path,len);
		}else{
			printPathRecur(node.left, path, len);
			printPathRecur(node.right, path, len);
		}
	}
	
	public void mirror(Node node){
		if(node == null){
			return;
		}
		
		Node temp;
		mirror(node.left);
		mirror(node.right);
		
		temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	public boolean sameTree(Node node1, Node node2 ){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 != null && node2 != null){
			return ( node1.data == node2.data &&
					 sameTree(node1.left,node2.left) && 
					 sameTree(node1.right, node2.right)
				   );	 
		}else{
			return false;
		}
	}

    public void leafSum(Node node, int sum){

        sum += node.data;
        if(node.left == null && node.right == null){
            System.out.print(sum + " ");
            return;
        }
        if(node.left != null){
            leafSum(node.left, sum);
        }
        if(node.right != null){
            leafSum(node.right, sum);
        }
    }
	
	public static void main(String[] args){
		
		BSTree tree = new BSTree();
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 2);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 0);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 10);

        tree.levelOrderTraversal(tree.root);
        tree.leafSum(tree.root, 0);
		/*tree.inOrderTraversal(tree.root);
		
		System.out.println();
		tree.printPaths(tree.root);
		System.out.println(tree.hasPathSums(tree.root, 21));
		tree.levelOrderTraversal(tree.root);
		tree.mirror(tree.root);
		tree.levelOrderTraversal(tree.root);
*/
	/*	
		System.out.println(tree.maxHeight(tree.root));
		System.out.println(tree.search(tree.root, 1));
		System.out.println(tree.size(tree.root));
		System.out.println(tree.minValue(tree.root));
	*/}
}
