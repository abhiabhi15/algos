package com.abhi.pblms;

import com.abhi.sorts.SortHelper;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;
	
	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity){
		pq = (Key[]) new Comparable[capacity +1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Key key){
		pq[++N] = key;
		swim(N);
	}
	
	public Key delMax(){
		
		Key max = pq[1];
		SortHelper.exch(pq, 1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
		
	}
	
	private void swim(int k){
		while( k > 1 && SortHelper.less(k/2,k)){
			SortHelper.exch(pq, k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){
		
		while (2*k <= N){
			
			int j = 2*k;
			if(j < N && SortHelper.less(j, j+1)){
				j++;
			}
			if(!SortHelper.less(k, j)){
				break;
			}
			SortHelper.exch(pq, k, j);
			k = j;
		}
	}
	
}
