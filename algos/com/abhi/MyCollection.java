package com.abhi;

import com.abhi.graphs.ai.GraphSearch;
import com.abhi.graphs.ai.SearchResult;
import com.abhi.graphs.ai.SearchSpace;
import com.abhi.pblms.Search;
import com.abhi.sorts.Sort;

/**
 * Created by abhishek on 9/25/14.
 */
public abstract class MyCollection {

    public static void sort(Sort sort,Comparable a[]){
        sort.sort(a);
    }

    public static int search(Search search, Comparable key, Comparable[] a) {
        return search.search(key,a);
    }

    public static SearchResult graphSearch(GraphSearch graphSearch, SearchSpace searchSpace, String startNode, String goalNode) {
        return graphSearch.search(searchSpace, startNode, goalNode);
    }
}
