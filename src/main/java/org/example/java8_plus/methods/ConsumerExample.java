package org.example.java8_plus.methods;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample<T> {
    public Consumer<T> consumer = (input) ->
            System.out.println("input = " + input);

    public void runConsumerExample(List<T> inputList) {
//        Consumer<T> tConsumer = consumer.andThen(consumer);
//        inputList.forEach(consumer);
        inputList.forEach(input -> consumer.accept(input));
    }
}
