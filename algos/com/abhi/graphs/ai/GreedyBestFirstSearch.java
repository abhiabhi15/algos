package com.abhi.graphs.ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by abhishek on 9/25/14.
 *
 */

public class GreedyBestFirstSearch implements GraphSearch{

    SearchResult searchResult;
    PriorityQueue<Path> priorityQueue;

    class Path{
        List<String> pathNodes;
        int pathCost;  //Heuristic Cost
    }

    public GreedyBestFirstSearch(){
        System.out.println("Executing Greedy Best First Search");
        searchResult = new SearchResult();
        priorityQueue = new PriorityQueue<Path>(300, new Comparator<Path>() {
            public int compare(Path p1, Path p2) {
                if(p1.pathCost <= p2.pathCost){
                    return -1;
                }
                return 1;
            }
        });
    }

    @Override
    public SearchResult search(SearchSpace ss, String startNode, String goalNode) {
        Node initialNode = ss.getNode(startNode);
        if(initialNode == null) return null;

        searchResult.expandNode(startNode);      //Initializing priority queue with path of one-length
        for(String node : initialNode.getNextNodes()){
            List<String> init_path = new ArrayList<String>();
            init_path.add(initialNode.getName());
            init_path.add(node);

            Path path = new Path();
            path.pathNodes = init_path;
            path.pathCost = (int) getHCost( ss.getNode(node), ss.getNode(goalNode));
            priorityQueue.add(path);
        }

        while (!priorityQueue.isEmpty()){

            Path topPath = priorityQueue.poll();
            String lastNode = topPath.pathNodes.get(topPath.pathNodes.size() - 1);

            if(lastNode.equalsIgnoreCase(goalNode)){                   //Performing goal-match
                searchResult.setPath(topPath.pathNodes);
                searchResult.setNodeFound(true);
                searchResult.setCost(topPath.pathCost);
                return searchResult;
            }

            Node node = ss.getNode(lastNode);
            searchResult.expandNode(lastNode);

            for(String nextNode : node.getNextNodes()){          //Expanding nodes
                List<String> path = new ArrayList<String>();
                path.addAll(topPath.pathNodes);
                path.add(nextNode);

                Path pathObj = new Path() ;
                pathObj.pathNodes = path;
                pathObj.pathCost = (int)getHCost(ss.getNode(nextNode), ss.getNode(goalNode));
                priorityQueue.add(pathObj);
            }
        }
        return searchResult;
    }

    private double getHCost(Node currentNode, Node goalNode){

        float lat1 = currentNode.getLatitude();
        float lat2 = goalNode.getLatitude();
        float long1 = currentNode.getLongitude();
        float long2 = goalNode.getLongitude();

        return Math.sqrt( 69.5 * Math.pow(lat1-lat2, 2) + (69.5 * Math.cos((lat1+lat2)/360 * Math.PI)) * Math.pow(long1-long2,2));
    }
}
