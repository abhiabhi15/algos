package com.abhi.sorts;

public class QuickSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		
		SortHelper.shuffle(a);
		sort(a, 0, a.length-1);
		
	}

	private int partition(Comparable[]a, int lo, int hi){
		
		int i = lo;
		int j = hi +1;
		
		while (true){
					
			while(SortHelper.less(a[++i], a[lo])){
				if(i == hi) break;
			}
			
			while(SortHelper.less(a[lo], a[--j])){
				if(j == lo) break;
			}
			
			if(i >= j) break;
			SortHelper.exch(a, i, j);
		}	
		
		SortHelper.exch(a, lo, j);
		System.out.println("Partition");
    	SortHelper.print(a);
		
		return j;
	}
	
	public void sort(Comparable[]a, int lo, int hi){
		
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
}
