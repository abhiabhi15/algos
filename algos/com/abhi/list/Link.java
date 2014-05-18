package com.abhi.list;

public class Link {

	int data;
	Link next;
	
	public Link(int data, Link next) {
	
		this.data = data;
		this.next = next;
	}

	public boolean equals(Link link){
		if(this.data == link.data){
			return true;
		}
		return false;
	}
	
	
}

