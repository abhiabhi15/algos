package com.abhi.containers;

/**
 * Created by abhishek
 * Created on 12/25/14.
 */

public class MaxHeap<Key extends Comparable<Key>>{
    private Key[] heap;
    private int N;

    public MaxHeap(int capacity){
        heap = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Key key){
        heap[++N] = key;
        swim(N);
    }

    public Key getMax(){
        Key max = heap[1];
        swap(1, N--);
        sink(1);
        heap[N+1] = null;
        return max;
    }

    private void swap(int pos1, int pos2){
        Key temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private void swim(int k){
        while( k > 1 && less(heap[k/2],heap[k])){
            swap(k , k/2);
            k = k/2;
        }
    }

    private void sink(int k){

        while( 2*k <= N){
            int j = 2*k;
            if( j < N && less(heap[j],heap[j+1])){
                j++;
            }
            if(!less(heap[k], heap[j])){
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap(10);
        mh.insert(2);mh.insert(-2);mh.insert(42);mh.insert(21);
        System.out.println(mh.getMax());
    }
}