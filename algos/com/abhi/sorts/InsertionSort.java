package com.abhi.sorts;

/**
 * @author abhishek
 *
 */

public class InsertionSort implements Sort{

	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a){
		
		for(int i = 1; i < a.length ; i++){
			for(int j = i; j > 0 ; j--){
				if(SortHelper.less(a[j], a[j-1])){
					SortHelper.exch(a, j, j-1);
				}else{
					break;
				}
			}	
		}
	
	}

}	
