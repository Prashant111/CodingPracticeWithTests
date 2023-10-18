package org.example.java8_plus.team_contribution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {
    private Problems problems;

    @BeforeEach
    void setUp() {
        problems = new Problems();
    }

    @Test
    void getDuplicatedStrings() {
        List<String> strings = List.of("one", "two", "three", "one", "two");
        List<String> actual = problems.getDuplicatedStrings(strings);
        assertEquals(List.of("one", "two"), actual);
    }
}