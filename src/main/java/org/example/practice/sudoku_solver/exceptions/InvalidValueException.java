package org.example.practice.sudoku_solver.exceptions;

public class InvalidValueException extends RuntimeException {

    public static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid value. Error message: ";

    public InvalidValueException(String errorMessage) {
        super(INVALID_VALUE_ERROR_MESSAGE + errorMessage);
    }
}
