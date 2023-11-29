package com.prashant.anonymous.common.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(Object input) {
        super("Invalid Input " + input);
    }
}
