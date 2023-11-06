package org.example.practice.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphBFSTraversalTest extends GraphsProvider {

    private GraphBFSTraversal graphBFSTraversal;

    @BeforeEach
    void setUp() {
        graphBFSTraversal = new GraphBFSTraversal(adjacencyListOrdinaryGraph);
    }

    @Test
    void testBFSTraversal() {
        List<Integer> bfs = graphBFSTraversal.bfs();
        assertEquals(List.of(0, 1, 2, 5, 3, 4, 6, 7, 9, 8),
                     bfs
                    );
    }
}