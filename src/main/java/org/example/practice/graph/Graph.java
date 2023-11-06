package org.example.practice.graph;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;

//adjacency list
public class Graph {
    protected Map<Integer, Collection<Integer>> adjacencyList;

    public Graph(Map<Integer, Collection<Integer>> adjacencyList) {
        initializeGraph(adjacencyList);
    }

    private void initializeGraph(@NotNull Map<Integer, Collection<Integer>> adjacencyList) {
        this.adjacencyList = Map.copyOf(adjacencyList);
    }
}
