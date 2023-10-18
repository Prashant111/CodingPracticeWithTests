package org.example.java8_plus.methods;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample<T> {
    private final Predicate<T> predicate = (input) -> input.hashCode() > 20;

    public List<T> usePredicate(List<T> inputList) {
//        predicate.test(inputList.get(0))
//        Predicate<T> and = predicate.and(predicate);
//        Predicate<T> or = predicate.or(predicate);
//        Predicate<T> negate = predicate.negate();

        Predicate<T> tPredicate = predicate.negate()
                                           .or(predicate)
                                           .and(predicate)
                                           .negate();
//        return inputList.stream().filter(input -> tPredicate.test(input)).collect(Collectors.toList());
//        return inputList.stream().filter(tPredicate::test).collect(Collectors.toList());
        return inputList
                .stream()
                .filter(tPredicate)
                .collect(Collectors.toList());
    }

}
