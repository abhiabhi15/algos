package com.abhi.graphs.ai;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhishek on 9/24/14.
 */
public class SearchResult {

    private boolean nodeFound;
    private List<String> nodeExpanded;
    private List<String> path;
    private Integer cost;

    public boolean isVisited(String node){
        return nodeExpanded.contains(node);
    }

    public void emptyNodeExpanded(){
        nodeExpanded = null;
    }

    public boolean isNodeFound() {
        return nodeFound;
    }

    public void setNodeFound(boolean nodeFound) {
        this.nodeFound = nodeFound;
    }

    public void expandNode(String node){
        if(nodeExpanded == null){
            nodeExpanded = new LinkedList<String>();
        }
        nodeExpanded.add(node);
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public List<String> getNodeExpanded() {
        return nodeExpanded;
    }

    @Override
    public String toString() {
        return "SearchResult{\n" +
                "   nodeFound = " + nodeFound + "\n" +
                "   nodeExpanded = " + nodeExpanded + "\n" +
                "   path = " + path + "\n" +
                "   cost = " + cost + "\n" +
                '}';
    }
}
