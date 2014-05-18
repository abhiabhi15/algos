package com.abhi.sorts;

import java.util.Random;

public abstract class SortHelper {

	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	public static void exch(Comparable[] a, int i,int j){
		
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static boolean isSorted(Comparable[] a){
		
		for(int i =0 ; i < a.length; i++){
			if(less(a[i],a[i+1])){
				return false;
			}
		}
		return true;
	}
	
	public static void print(Comparable[] a){
		
		for(int i = 0; i < a.length; i++){
			if(i == 0){
				System.out.print(a[i]);
			}else{
				System.out.print(" " + a[i] );
			}
		}
		System.out.println();
	}
	
	public static void sort(Sort sort,Comparable a[]){
		sort.sort(a);
	}

	public static void shuffle(Comparable a[]){
		Random rand = new Random();
		for(int i = 0;i < a.length; i++){
			int r = rand.nextInt(i+1);
			exch(a, i, r);
		}
	}
}
