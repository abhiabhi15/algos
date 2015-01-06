package com.abhi.graphs.undirected;

import com.abhi.containers.Bag;

/**
 * Author : abhishek
 * Created on 1/5/15.
 */
public class Graph {

    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i=0; i <V; i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        int edges = 0;
        for(Bag bag : adj){
            edges+= bag.size();
        }
        return edges/2;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        System.out.println(graph.E());
    }
}
