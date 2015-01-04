package com.abhi.interview;

/**
 * Created by abhishek
 * Unity Id : akagrawa
 * Created on 12/19/14.
 */

class DLink {

    int data;
    DLink prev;
    DLink next;

    public DLink(int data){
        this.data = data;
    }

    public DLink(int data, DLink prev, DLink next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

}

public class DoublyLinkedList {

    DLink head;
    DLink tail;

    public void addAtFirst(int num){
        if(head == null){
            head = new DLink(num);
            tail = head;
        }else {
            DLink link = new DLink(num, null, head);
            head.prev = link;
            head = link;
        }
    }

    public void printList(){
        if(head == null) return;
        DLink temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse(){
        DLink temp = head;
        head = tail;
        tail = temp;
        DLink ptr = head;
        while(ptr != null){
            temp = ptr.next;
            ptr.next = ptr.prev;
            ptr.prev = temp;
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addAtFirst(4);
        dl.addAtFirst(3);
        dl.addAtFirst(2);
        dl.addAtFirst(1);
        dl.printList();
        dl.reverse();
        dl.printList();
    }


}
