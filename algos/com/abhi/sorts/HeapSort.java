package com.abhi.sorts;

import com.abhi.Utils;

public class HeapSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		
		int N = a.length;
		for(int k = N/2; k >= 1; k--){
			sink(a, k, N);
		}
		
		while( N > 1){
			Utils.exch(a, 1, N);
			sink(a, 1, --N);
		}
	}
	
	
	private void sink(Comparable[] pq, int k, int N){
		
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
