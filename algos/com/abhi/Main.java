package com.abhi;

import com.abhi.pblms.BinarySearch;
import com.abhi.sorts.QuickSort;
import com.abhi.utils.InputNumbers;

public class Main {

	public static void main(String[] args){
		
		String[] arr = {"A", "A", "B", "B", "B", "B", "B", "A", "A", "A", "B", "A" };

        Integer[] nums = (Integer[])InputNumbers.getArrayNumbers(100,100);

		long st = System.currentTimeMillis();
		Utils.sort(new QuickSort(), nums);
        int key =1023;
        int pos = Utils.search(new BinarySearch(), key, nums);
        if(pos != -1){
            System.out.println("Key " + key + " found at position = " + pos);
        }else{
            System.out.println("Key " + key + " not found " );
        }
        System.out.println("Time Taken " + (System.currentTimeMillis() - st) + " milliseconds");

		
	}
	

}
