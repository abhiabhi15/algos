package com.abhi.graphs.undirected;

import java.util.Stack;

/**
 * Author : abhishek
 * Created on 1/5/15.
 */
public class DepthFirstSearch {

    private boolean[] marked; // marked[v] => is there a path from s-v?
    private int[] edgeTo;     // edgeTo[v] => Last edge on s-v path
    private final int s;      // source vertex

    public DepthFirstSearch(Graph G, int s){
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    //Depth Search from v
    private void dfs( Graph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    //APIs
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x =v; x != s; x=edgeTo[x]){
            path.push(v);
        }
        path.push(s);
        return path;
    }

}
