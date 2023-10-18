package org.example.practice.sudoku_solver.exceptions;

public class InvalidCoordinatesException extends RuntimeException {

    public static final String INVALID_COORDINATES_ERROR_MESSAGE = "Invalid coordinates. Error message: ";

    public InvalidCoordinatesException(String errorMessage) {
        super(INVALID_COORDINATES_ERROR_MESSAGE + errorMessage);
    }
}
