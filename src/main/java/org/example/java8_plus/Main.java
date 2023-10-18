package org.example.java8_plus;

import org.example.java8_plus.methods.ConsumerExample;
import org.example.java8_plus.methods.RunnableExample;
import org.example.java8_plus.methods.SupplierExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RunnableExample runnableExample = new RunnableExample();
        runnableExample.runnableUser();

        LamdaExamples lamdaExamples = new LamdaExamples();
        lamdaExamples.lamda1Example();

        ConsumerExample<String> consumerExample = new ConsumerExample<>();
        List<String> inputList = new ArrayList<>(Arrays.asList("Prashant", "Rahul", "Maninder"));
        consumerExample.runConsumerExample(inputList);

        SupplierExample supplierExample = new SupplierExample();
        System.out.println("s = " + supplierExample.useSupplier());
    }
}
