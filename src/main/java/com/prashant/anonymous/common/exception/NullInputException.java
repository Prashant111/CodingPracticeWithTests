package com.prashant.anonymous.common.exception;

public class NullInputException extends RuntimeException {
    public NullInputException() {
        super("Input is null");
    }
}
