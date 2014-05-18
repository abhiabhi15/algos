package com.abhi.sorts;

import com.abhi.utils.InputNumbers;

public class Main {
	
	public static void main(String[] args){
		
		String[] arr = {"A", "A", "B", "B", "B", "B", "B", "A", "A", "A", "B", "A" };
	
		long st = System.nanoTime();
		SortHelper.sort(new QuickSort(),arr);
		System.out.println("Time Taken " + (System.nanoTime() - st)/1000);
		SortHelper.print(arr);
		
	}
	

}
