package com.abhi.sorts;

import com.abhi.utils.Utils;

public class BubbleSort implements Sort{
	
	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a){
		for(int i = 0 ; i < a.length; i++){
			for(int j = a.length -1; j > i ; j--){
				if( Utils.less(a[j], a[j - 1]) ){
                    Utils.exch(a, j, j-1);
				}
			}
		}
	}

}
