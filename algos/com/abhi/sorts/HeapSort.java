package com.abhi.sorts;

public class HeapSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		
		int N = a.length;
		for(int k = N/2; k >= 1; k--){
			sink(a, k, N);
		}
		
		while( N > 1){
			SortHelper.exch(a, 1, N);
			sink(a, 1, --N);
			
			
		}
		
	}
	
	
	private void sink(Comparable[] pq, int k, int N){
		
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
