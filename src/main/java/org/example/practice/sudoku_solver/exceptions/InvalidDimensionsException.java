package org.example.practice.sudoku_solver.exceptions;

public class InvalidDimensionsException extends RuntimeException {

    public static final String INVALID_DIMENSIONS_ERROR_MESSAGE = "Invalid sudoku dimensions. Error message: ";

    public InvalidDimensionsException(String errorMessage) {
        super(INVALID_DIMENSIONS_ERROR_MESSAGE + errorMessage);
    }
}
