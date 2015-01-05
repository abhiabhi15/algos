package com.abhi.graphs.ai;

import java.util.Map;

/**
 * Created by abhishek on 9/24/14.
 */
public class SearchSpace {

    private Map<String,Node> map;

    public SearchSpace(Map<String, Node> map) {
        this.map = map;
    }

    public Node getNode(String nodeName){
        if(map.containsKey(nodeName)){
            return map.get(nodeName);
        }
        return null;
    }
}
