package com.prashant.anonymous.workshop;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SumUsingJava8 {
    public long getSumOfSquareOfEvenNumbers(List<Integer> numbers) {
        Predicate<Integer> evenNumbersFilter = num -> (num & 1) == 0;
        Function<Integer, Long> square = num -> (long) num * num;
        return getSumWithPredicate(numbers, evenNumbersFilter, square);
    }

    private long getSumWithPredicate(List<Integer> numbers, Predicate<Integer> intPredicate,
                                     Function<Integer, Long> operation) {
        return numbers.stream().filter(intPredicate).map(operation).reduce(0l, Long::sum);
    }
}
