package org.example.java8_plus.methods;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SupplierExample {

    Random random = new Random();
    private final Supplier<String> randomString = () -> {
        int randomLength = getRandomLength(10);
        return IntStream
                .range(0, randomLength)
                .mapToObj(i -> getRandomOneCharacterString())
                .reduce("", String::concat);
    };

    private String getRandomOneCharacterString() {
        String s = String.valueOf((char) (random.nextInt(26) + 'a'));
        return random.nextBoolean() ? s.toLowerCase() : s.toUpperCase();
    }

    private int getRandomLength(int endInclusion) {
        return random.nextInt(endInclusion - 1) + 1;
    }

    public String useSupplier() {
        BiPredicate<Integer, Integer> sumInLimit = (a, b) -> {
            long l;
            return Long.sum(a, b) <= Integer.MAX_VALUE && Long.sum(a, b) >= Integer.MIN_VALUE;
        };
        System.out.println(sumInLimit.test(Integer.MIN_VALUE, -1));
        return randomString.get();
    }
}
