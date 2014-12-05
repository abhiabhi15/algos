package com.abhi.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhishek on 9/25/14.
 */
public class DFIDSearch implements GraphSearch{

    SearchResult searchResult;
    Stack<List<String>> stack;

    public DFIDSearch(){
        System.out.println("Executing Depth First Iterative Deepening Search");
        searchResult = new SearchResult();
        stack = new Stack<List<String>>();
    }

    @Override
    public SearchResult search(SearchSpace ss, String startNode, String goalNode) {

        Node initialNode = ss.getNode(startNode);
        if(initialNode == null) return null;

        int cutoff = 1, cutoffIncrement = 1;
        boolean goalNotFound = true;

        while (goalNotFound){
            searchResult.expandNode(startNode);                          //Initializing stack with path of one-length
            for(String node : initialNode.getNextNodesInReverseOrder()){
                List<String> init_path = new ArrayList<String>();
                init_path.add(initialNode.getName());
                init_path.add(node);
                stack.add(init_path);
            }

            while (!stack.isEmpty()){
                List<String> topPath = stack.pop();
                String lastNode = topPath.get(topPath.size()-1);

                if(searchResult.isVisited(lastNode)){
                    continue;
                }

                if(lastNode.equalsIgnoreCase(goalNode)){
                    searchResult.setPath(topPath);
                    searchResult.setNodeFound(true);
                    return searchResult;
                }

                Node node = ss.getNode(lastNode);
                searchResult.expandNode(lastNode);  // To track the node expanded

                for(String nextNode : node.getNextNodesInReverseOrder()){
                    if(!searchResult.isVisited(nextNode)){

                        if(topPath.size() + 1 <= cutoff){
                            List<String> path = new ArrayList<String>();
                            path.addAll(topPath);
                            path.add(nextNode);
                            stack.add(path);
                        }
                    }
                }
               // System.out.println(" Node Expansion :: " + searchResult.getNodeExpanded());
            }
           // System.out.println("---------------------------------------------------------");
            cutoff += cutoffIncrement;
            searchResult.emptyNodeExpanded();
        }
        return searchResult;
    }
}
