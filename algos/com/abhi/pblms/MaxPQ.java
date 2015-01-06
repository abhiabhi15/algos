package com.abhi.pblms;

import com.abhi.utils.Utils;

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
		Utils.exch(pq, 1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
		
	}
	
	private void swim(int k){
		while( k > 1 && Utils.less(k / 2, k)){
			Utils.exch(pq, k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){
		
		while (2*k <= N){

			int j = 2*k;
			if(j < N && Utils.less(j, j+1)){
				j++;
			}
			if(!Utils.less(k, j)){
				break;
			}
			Utils.exch(pq, k, j);
			k = j;
		}
	}

}
