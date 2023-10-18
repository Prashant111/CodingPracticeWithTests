package org.example.practice.sudoku_solver.exceptions;

public class SudokuNotSolvableException extends RuntimeException {


    public SudokuNotSolvableException() {
        super("Sudoku not solvable");
    }
}
