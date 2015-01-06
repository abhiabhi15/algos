package com.abhi.sorts;

import com.abhi.utils.Utils;

/**
 * @author abhishek
 *
 */

public class InsertionSort implements Sort{

	@SuppressWarnings("rawtypes")
	public void sort(Comparable[] a){
		
		for(int i = 1; i < a.length ; i++){
			for(int j = i; j > 0 ; j--){
				if(Utils.less(a[j], a[j - 1])){
                    Utils.exch(a, j, j-1);
				}else{
					break;
				}
			}	
		}
	}

}	
