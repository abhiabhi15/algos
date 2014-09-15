package com.abhi.pblms;

/**
 * Created by abhishek on 9/15/14.
 */
public class BinarySearch implements Search{

    public int search(Comparable key, Comparable[] a){

        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(a[mid].compareTo(key) < 0){
                lo = mid +1;
            }else if(a[mid].compareTo(key) > 0){
                hi = mid -1;
            }else{
                return mid;     //Found the key at this position
            }
        }
        return -1;
    }
}
