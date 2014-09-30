package com.abhi.pblms;

/**
 * Created by abhishek on 9/16/14.
 */
public class LinearSearch implements Search {

    @Override
    public int search(Comparable key, Comparable[] a) {

        for(int i=0; i < a.length; i++){
            if(key.equals(a[i])){
                return i;
            }
        }
        return -1;
    }
}
