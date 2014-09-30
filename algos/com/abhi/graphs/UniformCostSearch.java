package com.abhi.graphs;

import java.util.*;

/**
 * Created by abhishek on 9/24/14.
 */
public class UniformCostSearch implements GraphSearch{

    SearchResult searchResult;
    PriorityQueue<Path> priorityQueue;

    class Path{
        List<String> pathNodes;
        int pathCost;

        @Override
        public String toString() {
            return "Path{" +
                    "pathNodes=" + pathNodes +
                    ", pathCost=" + pathCost +
                    '}';
        }
    }


    public UniformCostSearch(){
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
            path.pathCost = initialNode.getLinkPathCost(node);
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

            if(searchResult.isVisited(lastNode)){
                continue;
            }

            Node node = ss.getNode(lastNode);
            searchResult.expandNode(lastNode);

            for(String nextNode : node.getNextNodes()){          //Expanding nodes
                List<String> path = new ArrayList<String>();
                path.addAll(topPath.pathNodes);
                path.add(nextNode);

                Path pathObj = new Path() ;
                pathObj.pathNodes = path;
                pathObj.pathCost = topPath.pathCost + node.getLinkPathCost(nextNode);

                if(searchResult.isVisited(nextNode)){             //Removing costly paths with same last node
                   List<Path> commonPaths = getPathsWithSameLastNode(priorityQueue, nextNode);
                   if(commonPaths != null){
                       for(Path commonPath : commonPaths){
                           if(commonPath.pathCost > pathObj.pathCost){
                               priorityQueue.remove(commonPath);
                               priorityQueue.add(pathObj);
                           }
                       }
                   }
                }else {
                    priorityQueue.add(pathObj);
                }
            }
        }
        return searchResult;
    }

    private List<Path> getPathsWithSameLastNode(PriorityQueue<Path> priorityQueue, String node) {

        node = node.trim();
        List<Path> commonPaths = null;
        Iterator<Path> itr = priorityQueue.iterator();
        while (itr.hasNext()){
            Path path = itr.next();
            if(path.pathNodes.get(path.pathNodes.size()-1).equalsIgnoreCase(node)){
                if(commonPaths == null){
                    commonPaths = new ArrayList<Path>();
                }
                commonPaths.add(path);
            }
        }
        return commonPaths;
    }
}
