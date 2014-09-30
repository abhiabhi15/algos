package com.abhi.graphs;

import java.util.*;

/**
 * Created by abhishek on 9/24/14.
 */
public class Node {

    private String name;
    private Map<String, Integer> link;
    private float latitude;
    private float longitude;

    public Set<String> getNextNodes(){
      return link.keySet();
    }

    public List<String> getNextNodesInReverseOrder(){

        List<String> reverseList = new ArrayList<String>(link.keySet());
        Collections.reverse(reverseList);
        return reverseList;
    }

    public Integer getLinkPathCost(String nodeName){
        return link.get(nodeName);
    }

    public Node(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getLink() {
        return link;
    }

    public void setLink(Map<String, Integer> link) {
        this.link = link;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", link=" + link +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
