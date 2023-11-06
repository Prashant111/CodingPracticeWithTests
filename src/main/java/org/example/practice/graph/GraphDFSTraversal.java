package org.example.practice.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GraphDFSTraversal extends Graph {
    public GraphDFSTraversal(Map<Integer, Collection<Integer>> adjacencyList) {
        super(adjacencyList);
    }

    public List<Integer> dfs() {
        boolean[] visited = new boolean[adjacencyList.keySet().size()];
        List<Integer> dfsTraversal = new ArrayList<>();
        dfsHelper(0, visited, dfsTraversal);
        return dfsTraversal;
    }


    private void dfsHelper(int node, boolean[] visited, List<Integer> traversal) {
        if (visited[node])
            return;

        visited[node] = true;
        traversal.add(node);

        Collection<Integer> neighbours = adjacencyList.get(node);
        for (int neighbour : neighbours)
            dfsHelper(neighbour, visited, traversal);
    }
}
