package com.abhi.pblms;

import com.abhi.utils.InputNumbers;

public class WQuickUnion {

private Integer[] id;
private Integer[] size;
	
	public WQuickUnion(int N){
		
		id = new Integer[N];
		size = new Integer[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i){
		
		while(i != id[i]){
			i = id[i];
		}
		return i;
		
	}
	
	public boolean connected(int p,int q){
		
		return root(p) == root(q);
	}
	
	public void union(int p,int q){
		
		int i = root(p);
		int j = root(q);
		
		if(size[i] < size[j]){
			id[i] = j;
			size[j] += size[i];
		}else{
			id[j] = i;
			size[i] += size[j];
		}
	}
	
public static void main(String[] args){
		
		WQuickUnion wqu = new WQuickUnion(10);
		
		wqu.union(6,7);
		wqu.union(9,2);
		wqu.union(0,1);
		wqu.union(4,5);
		wqu.union(0,2);
		wqu.union(3,7);
		wqu.union(5,7);
		wqu.union(4,1);
		wqu.union(2,8);
		
		InputNumbers.printArray(wqu.id);
	}
	
}
