package com.abhi.list;

public class DoublyLinkList implements List{

	DLink head;
	DLink tail;
	

	public void addAtFirst(int num) {
		if(head == null){
			head = new DLink(num,null,null);
			tail = head;
		}else{
			DLink newLink = new DLink(num, null, head);
			head.prev = newLink;
			head = newLink;
		}
		
	}

	public void printList(){
		
		DLink temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	@Override
	public int size() {
		
		int counter = 0;
		DLink temp = head;
		while(temp != null){
			counter++;
			temp = temp.next;
		}
		return counter;
	}

	@Override
	public void addAtIndex(int index, int num) {
		if(index > size()){
			throw new ArrayIndexOutOfBoundsException("Index must be smaller than the list length");
		}
		
		if(index == 0 || size() == 0){
			DLink link  = new DLink(num,null,head);
			head = link;
		}else{
			DLink temp = head;
			for(int i = 1 ;i < index; i++){
				temp = temp.next;
			}
			DLink newLink = new DLink(num,temp,null);
			if(temp != tail){
				newLink.next = temp.next;
				temp.next.prev = newLink;
				temp.next = newLink;	
			}else{
				tail.next = newLink;
				tail = newLink;
			}
			
		}
		
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
	
		DoublyLinkList dLinkList = new DoublyLinkList();
		dLinkList.addAtFirst(2);
		dLinkList.addAtFirst(3);
		dLinkList.addAtFirst(4);
		dLinkList.addAtIndex(3, 12);
		dLinkList.printList();
		System.out.println(dLinkList.size());
	}
	
}
