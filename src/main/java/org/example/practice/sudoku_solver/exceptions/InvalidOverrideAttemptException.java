package org.example.practice.sudoku_solver.exceptions;

public class InvalidOverrideAttemptException extends RuntimeException {

    public static final String INVALID_OVERRIDE_ATTEMPT_ERROR_MESSAGE = "Invalid Override attempt. Error message: ";

    public InvalidOverrideAttemptException(String errorMessage) {
        super(INVALID_OVERRIDE_ATTEMPT_ERROR_MESSAGE + errorMessage);
    }
}
