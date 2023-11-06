package org.example.practice.graph;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GraphsProvider {
    protected final Map<Integer, Collection<Integer>>
            adjacencyListOrdinaryGraph = Map.of(
            0, List.of(1, 2, 5),
            1, List.of(0, 2, 3, 4),
            2, List.of(0, 1, 6),
            3, List.of(1, 5, 6, 7),
            4, List.of(1, 7),
            5, List.of(3),
            6, List.of(2, 3, 9),
            7, List.of(3, 4, 8),
            8, List.of(7),
            9, List.of(6)
                                               );
    protected final Map<Integer, Collection<Integer>>
            adjacencyListDisjointGraph = Map.of(
            0, List.of(4, 8, 13, 14),
            1, List.of(5),
            2, List.of(9, 15),
            3, List.of(9),
            4, List.of(0, 8),
            5, List.of(1, 16, 17),
            6, List.of(7, 11),
            7, List.of(6, 11),
            8, List.of(0, 4, 14),
            9, List.of(2, 3, 15)
                                               );
}

