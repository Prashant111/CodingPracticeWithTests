package org.example.java8_plus.methods;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    private final Function<Number, String> numberToString = String::valueOf;
    private final Function<String, Double> stringToDouble = Double::valueOf;


    public List<String> getStringsFromNumbers(List<Number> inputList) {
//        String apply = numberToString.apply(1);
//        String string = numberToString.toString();
//        Function<Number, Double> numberDoubleFunction = numberToString.andThen(stringToDouble);
//        Function<String, String> compose = numberToString.compose(stringToDouble);

        return inputList.stream()
//                        .map(num -> customToString.apply(num))
//                        .map(customToString::apply)
                        .map(numberToString)
                        .toList();


    }
}
