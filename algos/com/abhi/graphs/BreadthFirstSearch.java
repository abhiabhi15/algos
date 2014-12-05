package com.abhi.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhishek on 9/24/14.
 */
public class BreadthFirstSearch implements GraphSearch {

    SearchResult searchResult;
    Queue<List<String>> queue;

    public BreadthFirstSearch(){
        System.out.println("Executing Breadth First Search");
        searchResult = new SearchResult();
        queue = new LinkedList<List<String>>();
    }

     @Override
    public SearchResult search(SearchSpace ss, String startNode, String goalNode) {

         Node initialNode = ss.getNode(startNode);
         if(initialNode == null) return null;

         searchResult.expandNode(startNode);            //Initializing queue with path of one-length
         for(String node : initialNode.getNextNodes()){
             List<String> init_path = new ArrayList<String>();
             init_path.add(initialNode.getName());
             init_path.add(node);
             queue.add(init_path);
         }

         while (!queue.isEmpty()){
             List<String> topPath = queue.poll();
             String lastNode = topPath.get(topPath.size()-1);

             if(searchResult.isVisited(lastNode)){        // To check if the node is already visited
                 continue;
             }

             if(lastNode.equalsIgnoreCase(goalNode)){
                 searchResult.setPath(topPath);
                 searchResult.setNodeFound(true);
                 System.out.println(queue);
                 return searchResult;
             }

             Node node = ss.getNode(lastNode);
             searchResult.expandNode(lastNode);

             for(String nextNode : node.getNextNodes()){
                 if(!searchResult.isVisited(nextNode)){
                     List<String> path = new ArrayList<String>();
                     path.addAll(topPath);
                     path.add(nextNode);
                     queue.add(path);
                 }
             }
         }
         return searchResult;
    }
}
