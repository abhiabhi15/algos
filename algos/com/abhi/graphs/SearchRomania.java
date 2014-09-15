package com.abhi.graphs;

import java.util.*;

/**
 * Created by Abhishek Kumar Agrawal on 9/5/14.
 * Unity ID : akagrawa
 * Title : AI Assignment-1 Q:4a
 */

public class SearchRomania {

    private Map<String, List<String>> pathMap; //To store Romanian cities and its connections
    private Queue<String> traverseQueue;       // For BFS Implementation
    private Stack<String> traverseStack;       // For DFS Implementation
    private Map<String,Boolean> nodeVisited;

    public SearchRomania(){
        init();          // Loading the Map ADT with Romanian Cities
    }

    public List<String> searchPath(String searchType, String sourceCity, String destinationCity){

        List<String> path = new LinkedList<String>();
        sourceCity = sourceCity.toLowerCase();
        destinationCity = destinationCity.toLowerCase();

        //Initial checks for valid cities
        if(!pathMap.containsKey(sourceCity) || !pathMap.containsKey(destinationCity) || sourceCity.equalsIgnoreCase(destinationCity)){
            return path;
        }

        nodeVisited = new HashMap<String, Boolean>();

        if(searchType.equalsIgnoreCase("dfs")){
            traverseStack = new Stack<String>();
            depthFirstSearch(sourceCity, destinationCity, path);
        }else{
            traverseQueue = new LinkedList<String>();
            path.add(sourceCity);
            breadthFirstSearch(sourceCity, destinationCity, path);
        }
        return path;
    }

    private void depthFirstSearch(String sourceCity, String destinationCity, List<String> path) {

        if(sourceCity == null){
            return;
        }
        path.add(sourceCity);
        List<String> nodePath = pathMap.get(sourceCity);
        if(nodePath.contains(destinationCity)){   //Goal Testing
            path.add(destinationCity);
            return;
        }

        nodeVisited.put(sourceCity, Boolean.TRUE);       // Adding the city in visited list

        for(int i=nodePath.size()-1; i >= 0; i--){
            String node = nodePath.get(i);                // Performing node expansion
            if(!nodeVisited.containsKey(node)){          // Checking for already visited nodes
                traverseStack.add(node);
            }
        }
        depthFirstSearch(traverseStack.pop(), destinationCity, path);
    }

    private void breadthFirstSearch(String sourceCity, String destinationCity, List<String> path) {

        if(sourceCity == null){
            return;
        }

        List<String> nodePath = pathMap.get(sourceCity);
        if(nodePath.contains(destinationCity)){ //Goal Testing
            path.add(destinationCity);
            return;
        }

        nodeVisited.put(sourceCity, Boolean.TRUE);      //Adding the city in visited list

        for(String node :  nodePath){                   //Performing node expansion
            if(!nodeVisited.containsKey(node)){        // Checking for already visited nodes
                traverseQueue.add(node);
                if(!path.contains(node)){
                    path.add(node);
                }
            }
        }
        breadthFirstSearch(traverseQueue.poll(), destinationCity, path);
    }

    public static void main(String[] args) {

          if(args.length < 3){
            System.err.println("Please provide the correct inputs");
            System.exit(0);
          }

        SearchRomania sr = new SearchRomania();
        List<String> path = sr.searchPath(args[0], args[1], args[2]);
        if(path.size() == 0) {
            System.out.println("Path is of zero length or no path exists");
        }else {
            System.out.println(path);
            System.out.println("Length of the List : " + path.size());
        }

    }

    private void init() {
        pathMap = new HashMap<String, List<String>>();

        List<String> oredeaPath = new LinkedList<String>();
        oredeaPath.add("sibiu");oredeaPath.add("zerind");
        pathMap.put("oradea", oredeaPath);

        List<String> zerindPath = new LinkedList<String>();
        zerindPath.add("arad");zerindPath.add("oradea");
        pathMap.put("zerind", zerindPath);

        List<String> aradPath = new LinkedList<String>();
        aradPath.add("sibiu");aradPath.add("timisoara");aradPath.add("zerind");
        pathMap.put("arad", aradPath);

        List<String> timisoaraPath = new LinkedList<String>();
        timisoaraPath.add("arad");timisoaraPath.add("lugoj");
        pathMap.put("timisoara", timisoaraPath);

        List<String> lugojPath = new LinkedList<String>();
        lugojPath.add("mehadia");lugojPath.add("timisoara");
        pathMap.put("lugoj", lugojPath);

        List<String> mehadiaPath = new LinkedList<String>();
        mehadiaPath.add("dobreta");mehadiaPath.add("lugoj");
        pathMap.put("mehadia", mehadiaPath);

        List<String> dobretaPath = new LinkedList<String>();
        dobretaPath.add("craiova");dobretaPath.add("mehadia");
        pathMap.put("dobreta", dobretaPath);

        List<String> craiovaPath = new LinkedList<String>();
        craiovaPath.add("dobreta");craiovaPath.add("pitesti");craiovaPath.add("rimnicu_vilcea");
        pathMap.put("craiova", craiovaPath);

        List<String> rimnicu_vilceaPath = new LinkedList<String>();
        rimnicu_vilceaPath.add("craiova");rimnicu_vilceaPath.add("pitesti");rimnicu_vilceaPath.add("sibiu");
        pathMap.put("rimnicu_vilcea", rimnicu_vilceaPath);

        List<String> sibiuPath = new LinkedList<String>();
        sibiuPath.add("arad");sibiuPath.add("fagaras");sibiuPath.add("oradea");sibiuPath.add("rimnicu_vilcea");
        pathMap.put("sibiu", sibiuPath);

        List<String> fagarasPath = new LinkedList<String>();
        fagarasPath.add("bucharest");fagarasPath.add("sibiu");
        pathMap.put("fagaras", fagarasPath);

        List<String> pitestiPath = new LinkedList<String>();
        pitestiPath.add("bucharest");pitestiPath.add("craiova");pitestiPath.add("rimnicu_vilcea");
        pathMap.put("pitesti", pitestiPath);

        List<String> bucharestPath = new LinkedList<String>();
        bucharestPath.add("fagaras");bucharestPath.add("giurgiu");bucharestPath.add("pitesti");bucharestPath.add("urziceni");
        pathMap.put("bucharest", bucharestPath);

        List<String> giurgiuPath = new LinkedList<String>();
        giurgiuPath.add("bucharest");
        pathMap.put("giurgiu", giurgiuPath);

        List<String> neamtPath = new LinkedList<String>();
        neamtPath.add("iasi");
        pathMap.put("neamt", neamtPath);

        List<String> iasiPath = new LinkedList<String>();
        iasiPath.add("neamt");iasiPath.add("vaslui");
        pathMap.put("iasi", iasiPath);

        List<String> vasluiPath = new LinkedList<String>();
        vasluiPath.add("iasi");vasluiPath.add("urziceni");
        pathMap.put("vaslui", vasluiPath);

        List<String> urziceniPath = new LinkedList<String>();
        urziceniPath.add("neamt");urziceniPath.add("vaslui");urziceniPath.add("hirsova");
        pathMap.put("urziceni", urziceniPath);

        List<String> hirsovaPath = new LinkedList<String>();
        hirsovaPath.add("eforie");hirsovaPath.add("urziceni");
        pathMap.put("hirsova", hirsovaPath);

        List<String> eforiePath = new LinkedList<String>();
        eforiePath.add("hirsova");
        pathMap.put("eforie", eforiePath);

    }

}
