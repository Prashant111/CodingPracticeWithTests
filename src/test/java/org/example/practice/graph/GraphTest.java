package org.example.practice.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraphTest extends GraphsProvider {

    @Test
    void initializeGraphPositiveTest() {
        assertDoesNotThrow(() -> new Graph(adjacencyListOrdinaryGraph));
    }

    @Test
    void initializeGraphWithNullTest() {
        assertThrows(IllegalArgumentException.class,
                     () -> new Graph(null)
                    );
    }

    @Test
    void initializeGraphWithDisjointTest() {
        assertDoesNotThrow(() -> new Graph(adjacencyListDisjointGraph));
    }
}