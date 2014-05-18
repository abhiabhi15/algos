package com.abhi.list;

public class DLink {

	int data;
	DLink prev;
	DLink next;
	
	DLink(){
	}

	public DLink(int data, DLink prev, DLink next) {
	
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	
}
