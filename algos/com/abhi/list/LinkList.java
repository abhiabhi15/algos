package com.abhi.list;

public class LinkList implements List{
	
	Link head;
	
	public void addAtFirst(int num){
		Link link = new Link(num,head);
		head = link;
	}
	
	public int size(){
		
		int counter = 0;
		Link list = head; 
		while(list != null){
			counter++;
			list = list.next;
		}
		return counter;
	}
	
	public void addNode(Link link){
		Link temp=head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = link;
	}
	
	public void addAtIndex(int index,int num){
		
		if(index > size()){
			throw new ArrayIndexOutOfBoundsException("Index must be smaller than the list length");
		}
		
		if(index == 0 || size() == 0){
			Link link = new Link(num,head);
			head = link;
		}else{
			Link list = head;
			for(int i = 1 ;i < index; i++){
				list = list.next;
			}
			Link newLink = new Link(num,list.next);
			list.next = newLink;	
		}
	}

	public static void printList(Link list){
		
		while(list != null){
			System.out.print(list.data + " ");
			list = list.next;
		}		System.out.println();
	}
	
	public void delete(int index){
		
		if(index > size() || size() == 0){
			throw new ArrayIndexOutOfBoundsException("Index must be smaller than the list length");
		}
		
		if(index == 0){
			head = head.next;
		}else{
			Link list = head;
			for(int i = 1 ;i < index; i++){
				list = list.next;
			}
			list.next = list.next.next;
		}
	}
	
	public void readBackward(Link link){ //using recursion
		
		if(link.next != null){
			readBackward(link.next);
		}
		System.out.print( link.data + " ");
	}
	
	public static Link reverse(Link link){ //using recursion
		
		if(link == null || link.next == null){
			return link;
		}
		Link temp = reverse(link.next);
		link.next.next = link;
		link.next = null;
		return temp;
	}
	
	public void reverse(){ //Using Third Variable
	
		if(head == null || size() == 1){
			return;
		}
		
		Link movLink,temp;
		Link newLink = head;
		head = head.next;
		newLink.next = null;
		movLink = head;
		while(movLink != null){
			temp = movLink.next;
			movLink.next = newLink;
			newLink = movLink;
			movLink = temp;
		}
		head = newLink;
	}
	
	public static boolean findLoop(Link link){
		
		Link current = link;
		Link temp = link.next;
		while(temp != null && current != null){
			
			if(current == temp){
				System.out.println("Loop Detected");
				return true;
			}
			current = current.next;
			temp = (temp.next != null) ? temp.next.next : temp.next;
		}
		return false;
	}

	public void makeLoop(){
		Link link = head;
		while(link.next != null){
			link = link.next;
		}
		link.next = head;
	}
	
	public static Link addNumberInRev( Link list1, Link list2, int carry){
		
		if(list1 == null && list2 == null && carry == 0 ){
			return null;
		}
		
		int value = carry;
		if(list1 != null){
			value += list1.data;
		}
		if(list2 != null){
			value += list2.data;
		} 
		
		Link result = new Link(value % 10, null);
		if(list1 != null || list2 != null){
			result.next = addNumberInRev((list1 != null) ? list1.next : null,
										 (list2 != null) ? list2.next : null, (value >= 10) ? 1 : 0);
		}
		return result;
	}

	public static void main(String[] args){
		
		LinkList list = new LinkList();
		list.addAtFirst(1);
		list.addAtFirst(2);
		list.addAtFirst(1);
//		list.addAtFirst(4);
		printList(list.head);
		
		LinkList list2 = new LinkList();
		list2.addAtFirst(8);
		list2.addAtFirst(2);
		list2.addAtFirst(3);
	//	list2.addAtFirst(4);
		printList(list2.head);
		
		Link l1 = reverse(list.head);
		Link l2 = reverse(list2.head);
		
		Link result = addNumberInRev(l1, l2, 0);
		printList(reverse(result));
		//Link result = 
		
	//	System.out.println(list.getListSize());
		//list.printList();
	/*	list.addAtIndex(2, 3);
		list.addAtIndex(1, 13);
		list.addAtIndex(2, 4);
		list.printList();
		list.delete(13);
		list.reverse(); */
		//printList(list.head);
		//list.makeLoop();
		//System.out.println(findLoop(list.head));
		//list.readBackward(list.head);
		//System.out.println();
		//list.head = list.reverse(list.head);
		//list.printList();
	}

}
