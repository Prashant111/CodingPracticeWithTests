package org.example.practice.graph;

import java.util.*;

public class GraphBFSTraversal extends Graph {
    public GraphBFSTraversal(Map<Integer, Collection<Integer>> adjacencyList) {
        super(adjacencyList);
    }

    public List<Integer> bfs() {
        List<Integer> traversalList = new ArrayList<>();
        boolean[] visited = new boolean[adjacencyList.keySet().size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) continue;

            traversalList.add(current);
            visited[current] = true;

            addNeighborsInQueueIfEligible(current, visited, queue);
        }
        return traversalList;
    }

    private void addNeighborsInQueueIfEligible(int current, boolean[] visited, Queue<Integer> queue) {
        Collection<Integer> neighbors = adjacencyList.get(current);
        for (int neighbor : neighbors) {
            addNeighborInQueueIfNotVisited(neighbor, visited, queue);
        }
    }

    private static void addNeighborInQueueIfNotVisited(int neighbor, boolean[] visited, Queue<Integer> queue) {
        if (!visited[neighbor]) queue.add(neighbor);
    }
}
