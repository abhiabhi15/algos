package com.abhi.sorts;

public class BubbleSort implements Sort{
	
	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a){
		for(int i = 0 ; i < a.length; i++){
			for(int j = a.length -1; j > i ; j--){
				if( SortHelper.less(a[j], a[j-1]) ){
					SortHelper.exch(a, j, j-1);
				}
			}
		}
	}
	
	
	
}
