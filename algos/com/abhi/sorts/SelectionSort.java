package com.abhi.sorts;

import com.abhi.Utils;

public class SelectionSort implements Sort{

	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] a) {
		
		for(int i = 0 ; i < a.length-1; i++){
			for(int j = i+1; j < a.length; j++){
				if(Utils.less(a[j], a[i])){
					Utils.exch(a, i, j);
				}
			}
		}
	}
	
	

}
