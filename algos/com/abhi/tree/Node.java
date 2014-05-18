package com.abhi.tree;

public class Node {

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
