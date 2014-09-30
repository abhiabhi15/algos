package com.abhi;

import com.abhi.graphs.*;
import com.abhi.pblms.LinearSearch;
import com.abhi.sorts.QuickSort;
import com.abhi.utils.InputNumbers;

public class Main {


    public static void sort(){
        String[] arr = {"A", "A", "B", "B", "B", "B", "B", "A", "A", "A", "B", "A" };

        Integer[] nums = (Integer[])InputNumbers.getArrayNumbers(100,100);

        long st = System.currentTimeMillis();
        MyCollection.sort(new QuickSort(), nums);
        System.out.println("Time Taken " + (System.currentTimeMillis() - st) + " milliseconds");

    }

    public static void search(){
        String[] arr = {"A", "A", "B", "B", "B", "B", "B", "A", "A", "A", "B", "A" };

        Integer[] nums = (Integer[])InputNumbers.getArrayNumbers(100,100);

        long st = System.currentTimeMillis();

        int key =10;
        int pos = MyCollection.search(new LinearSearch(), key, nums);
        if(pos != -1){
            System.out.println("Key " + key + " found at position = " + pos);
        }else{
            System.out.println("Key " + key + " not found " );
        }
        System.out.println("Time Taken " + (System.currentTimeMillis() - st) + " milliseconds");
    }

    public static void graphSearch(){

        GraphData graphData = new GraphData();

        SearchSpace searchSpace = graphData.getUSASearchSpace();

        //SearchResult searchResult = Utils.graphSearch( new UniformCostSearch(), searchSpace, "arad", "bucharest");

        SearchResult searchResult = MyCollection.graphSearch( new GreedyBestFirstSearch(), searchSpace, "montreal", "wichita");

        System.out.println(searchResult.getPath());
        System.out.println(searchResult.getNodeExpanded());
        System.out.println(searchResult.isNodeFound());
        System.out.println(searchResult.getCost());
    }

    public static void testFunction(){
    }

	public static void main(String[] args){
		
		//testFunction();
		graphSearch();
	}
	

}
