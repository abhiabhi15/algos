package com.abhi.sorts;

import com.abhi.Utils;

public class QuickSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		
		Utils.shuffle(a);
		sort(a, 0, a.length-1);
	}

    public void sort(Comparable[]a, int lo, int hi){

        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

	private int partition(Comparable[]a, int lo, int hi){
		
		int i = lo;
		int j = hi +1;
		
		while (true){
					
			while(Utils.less(a[++i], a[lo])){
				if(i == hi) break;
			}
			
			while(Utils.less(a[lo], a[--j])){
				if(j == lo) break;
			}
			
			if(i >= j) break;
			Utils.exch(a, i, j);
		}	
		
		Utils.exch(a, lo, j);
		return j;
	}
	

	
}
