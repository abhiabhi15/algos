package com.abhi.sorts;

import com.abhi.utils.Utils;

public class ShellSort implements Sort{

	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] a) {
		
		int N = a.length;
		int h = 1;
		while( h < N/3){
			h = 3 *h + 1 ;
		}
	
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i ; j >= h && Utils.less(a[j], a[j-h]); j-=h ){
					Utils.exch(a, j, j - h);
				}
			}
			h = h/3;
		}
	}
}
