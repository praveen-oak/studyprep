package com.practice.algorithms.utils.datastructures;

import org.apache.log4j.Logger;

import java.util.*;

public class LinkedGraph implements IGraph
{

    private static Logger log = Logger.getLogger(LinkedGraph.class);

    private int noOfVertices;

    private Map<Integer, List<Integer>> graph;

    public LinkedGraph(int noOfVertices) {

        this.noOfVertices = noOfVertices;
        graph = new HashMap<Integer, List<Integer>>();

    }

    public int getNoOfVertices() {

        return noOfVertices;
    }

    @Override
    public void addNode(int parentVertex, int childVertex) {

        if (graph.containsKey(parentVertex)) {

            graph.get(parentVertex).add(childVertex);

        } else {

            if (graph.size() == noOfVertices) {

                log.error("LinkedGraph.addNode  -  Graph reached the maximum size. No more new nodes can be added !!");
            } else {

                List<Integer> vertices = new LinkedList<Integer>();
                vertices.add(childVertex);
                graph.put(parentVertex, vertices);
            }
        }
    }

    @Override
    public void addNode(int parentVertex, int childVertex, int weight) {

        log.warn("LinkedGraph.addNode  -  No implementation available !!");
    }

    @Override
    public void depthFirstTraversal() {

        Set<Integer> vertices = graph.keySet();
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        List<Integer> dft = new LinkedList<Integer>();

        for (int vertex : vertices) {

            dfs(vertex, visited, dft);
        }

        log.info("LinkedGraph.addNode  -  DepthFirstTraversal: " + dft.toString());

    }

    @Override
    public void breadthFirstTraversal() {

    }

    private void dfs(int vertex, Map<Integer, Boolean> visited, List<Integer> dft) {

        if (visited.get(vertex)) {

            return;
        }

        dft.add(vertex);
        visited.put(vertex, true);

        List<Integer> vertices = graph.get(vertex);
        for (int connectedVertex : vertices) {

            dfs(connectedVertex, visited, dft);
        }

    }

}
