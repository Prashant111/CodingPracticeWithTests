package org.example.practice.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphDFSTraversalTest extends GraphsProvider {

    private GraphDFSTraversal graphDFSTraversal;

    @BeforeEach
    void setUp() {
        graphDFSTraversal = new GraphDFSTraversal(adjacencyListOrdinaryGraph);
    }

    @Test
    void testDFSTraversal() {
        List<Integer> dfs = graphDFSTraversal.dfs();
        assertEquals(List.of(0, 1, 2, 6, 3, 5, 7, 4, 8, 9), dfs);
    }
}