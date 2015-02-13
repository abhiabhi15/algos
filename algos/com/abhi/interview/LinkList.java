package com.abhi.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhishek
 * Created on 12/16/14.
 */

class Link {

    int data;
    Link next;

    Link(int data, Link next){
        this.data =data;
        this.next = next;

    }
}

public class LinkList{

        Link head;
        Link htemp;

        public void addAtFirst(int num){
            Link link = new Link(num, null);
            link.next = head;
            head = link;
        }

        public void addAtLast(int num){
            if(head == null){
                head = new Link(num, null);
                return;
            }
            Link temp = head;
            while( temp.next != null ){
                temp = temp.next;
            }
            temp.next = new Link(num, null);
        }

        public void printList(){
            if(head == null){ return;}
            Link temp = head;
            while(temp != null){
                System.out.print( temp.data + " ->  ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void printList(Link link){
            if(link == null){ return;}
            Link temp = link;
            while(temp != null){
                System.out.print( temp.data + " ->  ");
                temp = temp.next;
            }
            System.out.println();
        }

        public void getNthFromLast(int n){
            Link temp=head;
            for(int i =0; i < n; i++){
                temp = temp.next;
            }
            Link ptr = head;
            while(temp != null){
                temp = temp.next;
                ptr = ptr.next;
            }
            System.out.println( " Data at " + n + "th from last = " + ptr.data);
        }

    // Without recursion
        public void reverse(){

            Link current = head;
            Link next = null;
            Link prev = null;

            while (current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        public Link reverse(Link link){
            if(link == null || link.next == null){
                return link;
            }
            Link temp = reverse(link.next);
            link.next.next = link;
            link.next = null;
            return temp;
        }

        public Link getNthNode(int n){
            Link temp = head;
            for( int i = 1; i < n ; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public Link deleteList(Link link){
            if( link == null) return null;
            if(link.next != null){
                deleteList(link.next);
            }
            link = null;
            return null;
        }

        public int counter(int num){
            Link temp = head;
            int counter = 0;
            while(temp.next != null){
                if(temp.data == num){
                    counter++;
                }
                temp = temp.next;
            }
            return counter;
        }

        public boolean isPalindrome( Link link){
            if(link == null){
                return true;
            }
            if(!isPalindrome(link.next)){
                return false;
            }
            boolean isp = ( htemp.data == link.data) ? true : false;
            htemp = htemp.next;
            return isp;
        }

        public void removeDuplicates(){
            Set<Integer> numSet = new HashSet<>();
            Link temp = head;
            numSet.add(temp.data);
            while(temp.next != null){
                if(numSet.contains(temp.next.data)){
                    temp.next = temp.next.next;
                }else{
                    numSet.add(temp.next.data);
                    temp = temp.next;
                }
            }
        }

        public void removeDuplicateFromSorted(){
            Link temp = head;
            while(temp.next != null){
                if(temp.data == temp.next.data){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
        }

        //Using Recursion
        public void printReverse(Link link){
            if(link == null){
                return;
            }
            printReverse(link.next);
            System.out.print(link.data + "  ");
        }

        public void moveLastToFirst(){

            Link temp = head;
            while( temp.next.next != null){
                temp = temp.next;
            }
            Link last = temp.next;
            temp.next = null;
            last.next = head;
            head = last;
        }

        public int length(Link link){

            Link temp = link;
            int count =0;
            while(temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }

        public void junctionPoint( Link link1, Link link2){
            int len1 = length(link1);
            int len2 = length(link2);
            int d = len1 - len2;
            if( d > 0 ) {
                for(int i =0; i < d ; i++) {
                    link1 = link1.next;
                }
            }else if( d < 0 ) {
                for(int i =0; i < Math.abs(d) ; i++) {
                    link2 = link2.next;
                }
            }
            while( link1 != null){
                if(link1 == link2){
                    System.out.println(" Junction Point Found : Data => " + link1.data);
                    return;
                }else{
                    link1 = link1.next;
                    link2 = link2.next;
                }
            }
        }

        public void insertInSorted(int num){
            Link temp = head;
            Link node = new Link(num, null);
            if(temp.data > num){
                node.next = temp;
                head = node;
                return;
            }
            while( temp.next != null && temp.next.data < num){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }

        public void circularTwoHalves(){
            Link walker = head;
            Link runner = head.next;
            while(runner.next != head || runner.next.next != head){
                walker = walker.next;
                runner = runner.next.next;
            }
            if(runner.next == head){
                runner.next = walker.next;
            }else if(runner.next.next == head){
                runner.next.next = walker.next;
            }
            htemp = walker.next;
            walker.next = head;
        }

        public void createLoop(){

            Link temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = head;
        }

        public void printLoop(Link link){
            Link temp = link;
            while(temp.next != link){
                System.out.print(temp.data + "  -> ");
                temp = temp.next;
            }
            System.out.print(temp.data + "\n");
        }

        public void oddEvens(){

            Link curr = head;
            Link prev = head;
            while(curr != null && curr.data % 2 == 0 ){
                prev = curr;
                curr = curr.next;
            }
            while (curr != null){
                if(curr.data % 2 != 0){
                    prev = curr;
                    curr = curr.next;
                }else{
                    prev.next = curr.next;
                    curr.next = head;
                    head = curr;
                    curr = prev.next;
                }
            }
        }

        public void oddEvenOrder(){
            Link end = head;
            while(end.next != null){
                end = end.next;
            }
            Link stop = end;
            Link current = head;
            Link prev = null;
            while(current.data % 2 != 0 && current != stop){
                end.next = current;
                end = current;
                current = current.next;
                end.next = null;
            }

            if(current.data % 2 == 0) {
                head = current;
                while(current != stop){
                    if(current.data % 2 == 0){
                        prev = current;
                        current = current.next;
                    }else{
                        end.next = current;
                        end = current;
                        current = current.next;
                        prev.next = current;
                        end.next = null;
                    }
                }
            }else{
                prev = current;
            }
            if(stop!= end && stop.data % 2 != 0){
                prev.next = stop.next;
                stop.next = null;
                end.next = stop;
            }
        }

        public void greaterRightSide(){
            reverse();
            int max= head.data;
            Link temp = head;
            Link ptr = head;

            while(temp != null){
                if(temp.data < max){
                    ptr.next = temp.next;
                }else{
                    max = temp.data;
                    ptr = temp;
                }
                temp = temp.next;
            }
            reverse();
        }

        public void pairwiseSwap(Link link){
            link = reverseKNodes(link, 2);
            printList(link);
        }

        public Link reverseKNodes(Link link, int k){
            Link current = link;
            Link next = null;
            Link prev  = null;

            int counter = 0;
            while(current != null && counter < k){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                counter++;
            }

            if(next != null){
                link.next = reverseKNodes(next, k);
            }
            return prev;

        }

    public static void main(String[] args){
            LinkList linkList = new LinkList();
            linkList.addAtFirst(12);linkList.addAtLast(31);linkList.addAtLast(4);
            linkList.addAtLast(2);
          linkList.addAtLast(15);linkList.addAtLast(23); linkList.addAtLast(6);linkList.addAtLast(7);

           //linkList.printList(linkList.head);


        linkList.printList();
        linkList.pairwiseSwap(linkList.head);

        //linkList.head = linkList.reverseKNodes(linkList.head, 3);
         //   linkList.printList();
        //linkList.greaterRightSide();linkList.printList();
         /*//linkList.insertInSorted(175);
            linkList.createLoop();
            linkList.printLoop(linkList.head);
            linkList.circularTwoHalves();
        linkList.printLoop(linkList.head);
        linkList.printLoop(linkList.htemp);
*/
        //linkList.removeDuplicateFromSorted();

          //  linkList.moveLastToFirst();
         //   linkList.removeDuplicates();
           // linkList.getNthFromLast(2);
          //  linkList.printList();
           // linkList.head =linkList.reverse(linkList.head);
           // linkList.htemp = linkList.head;
           // Link right = linkList.head;
           // boolean check = linkList.isPalindrome(right);
           // System.out.println("Palindrome check " + check);
           // linkList.printReverse(linkList.head);

        /*LinkedList linkList2 = new LinkedList();
        linkList2.addAtFirst(7);
        linkList2.head.next = linkList.head;
        linkList2.addAtFirst(2);
        linkList2.addAtFirst(3);
        linkList.addAtFirst(11);linkList.addAtFirst(65);
        linkList.printList();
        linkList2.printList();
         linkList.junctionPoint(linkList.head, linkList2.head);*/
    }
 }



