package org.example.java8_plus.methods;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample<T> {
    public Consumer<T> consumer = (input) ->
            System.out.println("output = " + input);

    public void runConsumerExample(List<T> inputList) {
        inputList.forEach(input -> consumer.accept(input));
    }
}
