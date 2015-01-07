package com.abhi.graphs.undirected;

import com.abhi.containers.Bag;

/**
 * Author : abhishek
 * Created on 1/5/15.
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i=0; i <V; i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V){
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void showEdges(){
        for(int v=0; v < V; v++){
            for(int w : adj[v] ){
                System.out.println(v + " - " + w);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        System.out.println(graph.E());
        graph.showEdges();
    }
}
