package com.abhi.sorts;

import com.abhi.Utils;

public class HeapSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		
		int N = a.length-1;
		for(int k = N/2; k >= 0; k--){
			sink(a, k, N);
		}
		
		while( N > 0){
			Utils.exch(a, 0, N);
			sink(a, 0, --N);
		}
	}
	
	
	private void sink(Comparable[] pq, int k, int N){
		
		while (2*k+1 <= N){
			
			int j = 2*k+1;
			if(j < N && Utils.less(pq, j, j+1)){
				j++;
			}
			if(!Utils.less(pq,k, j)){
				break;
			}
            Utils.exch(pq, k, j);
			k = j;
		}
	}	

}
