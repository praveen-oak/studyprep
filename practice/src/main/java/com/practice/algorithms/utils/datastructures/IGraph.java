package com.practice.algorithms.utils.datastructures;

public interface IGraph {

    public void addNode(int parentVertex, int childVertex);

    public void addNode(int parentVertex, int childVertex, int weight);

    public void depthFirstTraversal();

    public void breadthFirstTraversal();

}
