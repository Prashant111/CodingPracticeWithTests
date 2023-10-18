package org.example.java8_plus.methods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerServiceExampleTest {

    private ConsumerExample<String> consumerExample;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        consumerExample = new ConsumerExample<>();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void runConsumerExample() {
        List<String> inputList = new ArrayList<>(Arrays.asList("Prashant", "Rahul", "Maninder"));

        String capturedOutput = outputStreamCaptor.toString()
                                                  .trim();
        consumerExample.runConsumerExample(inputList);
        System.out.println("capturedOutput = " + capturedOutput);

        assertEquals("Expected Output", capturedOutput);
    }
}