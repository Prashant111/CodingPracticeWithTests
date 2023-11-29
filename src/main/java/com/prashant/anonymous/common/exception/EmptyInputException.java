package com.prashant.anonymous.common.exception;

public class EmptyInputException extends RuntimeException {
    public EmptyInputException() {
        super("Input is empty.");
    }
}
