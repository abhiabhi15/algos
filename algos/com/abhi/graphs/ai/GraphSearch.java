package com.abhi.graphs.ai;

/**
 * Created by abhishek on 9/24/14.
 */
public interface GraphSearch{

    public SearchResult search(SearchSpace ss, String startNode, String goalNode);
}
