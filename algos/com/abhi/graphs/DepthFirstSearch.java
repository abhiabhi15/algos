package com.abhi.graphs;

import java.util.*;

/**
 * Created by abhishek on 9/24/14.
 */
public class DepthFirstSearch implements GraphSearch {

    SearchResult searchResult;
    Stack<List<String>> stack;

    public DepthFirstSearch(){
        searchResult = new SearchResult();
        stack = new Stack<List<String>>();
    }

    @Override
    public SearchResult search(SearchSpace ss, String startNode, String goalNode) {

        Node initialNode = ss.getNode(startNode);           //Initializing stack with path of one-length
        if(initialNode == null) return null;

        searchResult.expandNode(startNode);
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
                //System.out.println(stack);
                return searchResult;
            }

            Node node = ss.getNode(lastNode);
            searchResult.expandNode(lastNode);  // To track the node expanded

            for(String nextNode : node.getNextNodesInReverseOrder()){
                if(!searchResult.isVisited(nextNode)){
                    List<String> path = new ArrayList<String>();
                    path.addAll(topPath);
                    path.add(nextNode);
                    stack.add(path);
                }
            }
        }
        return searchResult;
    }
}
