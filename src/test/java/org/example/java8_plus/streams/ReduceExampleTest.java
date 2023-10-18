package org.example.java8_plus.streams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReduceExampleTest {

    private ReduceExample reduceExample = new ReduceExample();

    @BeforeEach
    public void setup() {
        reduceExample = new ReduceExample();
    }

    @Test
    public void getSumOfNumbers() {
        int actual = reduceExample.getSumOfNumbers(List.of(1, 2, 3, 4, 5, 6, 7));
        assertEquals(28, actual);
    }
}