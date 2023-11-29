package com.prashant.anonymous.epam.count_characters;

public class NoStringAvaialbleException extends RuntimeException {
    public NoStringAvaialbleException(String input) {
        super();
        System.out.println("Null input string exception");
    }
}
