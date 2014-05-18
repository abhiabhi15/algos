package com.abhi.pblms;

import com.abhi.utils.InputNumbers;

public class QuickFind {
	
	private Integer[] id;
	
	public QuickFind(int N){
		
		id = new Integer[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}

	public boolean connected(int p, int q){
		return id[p] == id[q];
	}
	
	public void union(int p,int q){
		
		int pid = id[p];
		int qid = id[q];
		
		for(int i = 0; i < id.length; i++){
			if(id[i] == pid){
				id[i] = qid;
			}
		}
	}	
		
	public static void main(String[] args){
		
		QuickFind qf = new QuickFind(10);
		
		qf.union(6, 7);
		qf.union(7, 5);
		qf.union(7, 9);
		qf.union(2, 9);
		qf.union(6, 0);
		qf.union(1, 5);
		
		InputNumbers.printArray(qf.id);
	}
	
	
}
