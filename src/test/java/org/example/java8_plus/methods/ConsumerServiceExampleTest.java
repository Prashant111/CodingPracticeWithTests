package org.example.java8_plus.methods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsumerServiceExampleTest {

    private static ByteArrayOutputStream outContent;
    private static PrintStream originalOut;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testRunConsumerExample_Integer() {
        List<Integer> inputList = Arrays.asList(1, 2, 3);
        ConsumerExample<Integer> consumerExample = new ConsumerExample<>();

        consumerExample.runConsumerExample(inputList);

        assertEquals("output = 1\noutput = 2\noutput = 3\n", getConsoleOutput());
    }

    // Helper method to capture console output
    private String getConsoleOutput() {
        return outContent.toString();
    }

    @Test
    void testRunConsumerExample_String() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry");
        ConsumerExample<String> consumerExample = new ConsumerExample<>();

        consumerExample.runConsumerExample(inputList);

        assertEquals("output = apple\noutput = banana\noutput = cherry\n", getConsoleOutput());
    }
}