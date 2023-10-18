package org.example.java8_plus.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReduceExample {
    public int getSumOfNumbers(List<Integer> inputList) {
        OptionalInt optionalInt = OptionalInt.of(1);

        return inputList
                .stream()
//                        .reduce(0, (total, num) -> total + num);
//                        .reduce(0, Integer::sum);
//                        .mapToInt(Integer::valueOf).sum();
                .collect(Collectors.summingInt(Integer::intValue));
    }
}

