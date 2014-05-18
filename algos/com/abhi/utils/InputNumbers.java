package com.abhi.utils;

import java.util.Random;

public abstract class InputNumbers {

	public static Object getArrayNumbers(int count, int maxLimit){
		
		Integer[] intArray = new Integer[count];
		Random rand = new Random();
		for(int i = 0; i < count; i++){
			intArray[i] = rand.nextInt(maxLimit);
		}
		return intArray;
	}
	
	public static void printArray(Object[] array){
		
		for(int i = 0; i < array.length; i++){
			if(i == 0){
				System.out.print(array[i]);
			}else{
				System.out.print(" " + array[i] );
			}
		}
		System.out.println();
	}

	public static void printArray(Object[] array,int length){
		
		for(int i = 0; i < length; i++){
			if(i == 0){
				System.out.print(array[i]);
			}else{
				System.out.print(" " + array[i] );
			}
		}
		System.out.println();
	}
	
}
