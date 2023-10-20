package org.example.practice.sudoku_solver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static org.example.practice.sudoku_solver.SudokuSolverPrinter.printSudoku;
import static org.example.practice.sudoku_solver.validation.SudokuValidation.isSudokuSolved;
import static org.example.practice.sudoku_solver.validation.SudokuValidation.isSudokuValid;
import static org.example.utilities.ColorUtils.getColoredText;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SudokuSolverTest extends BaseSudokuSolverTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void sudokuValidTest1() {
        sudokuValueValidator(initializeSudokuCells1());
    }

    private void sudokuValueValidator(SudokuCell[][] sudokuCells) {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuCells);
        boolean isSudokuValid = sudokuSolver.validateValues();
        assertTrue(isSudokuValid);
    }

    @Test
    void sudokuValidTest2() {
        sudokuValueValidator(initializeSudokuCells2());
    }

    @Test
    void sudokuValidTest3() {
        sudokuValueValidator(initializeSudokuCells3());
    }

    @Test
    void sudokuValidTest4() {
        sudokuValueValidator(initializeSudokuCells4());
    }

    @Test
    void sudokuValidTest5() {
        sudokuValueValidator(initializeSudokuCells5());
    }

    @Test
    void sudokuValidTest6() {
        sudokuValueValidator(initializeSudokuCells6());
    }

    @Test
    void sudokuSolverTest1() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells1());
    }

    private void assertSudokuValidAndValidateSolution(SudokuCell[][] sudokuCells) {
        SudokuSolver sudokuSolver = new SudokuSolver(sudokuCells);
        System.out.println(getColoredText("Given sudoku", RED, true, true));
        printSudoku(sudokuSolver.getSudokuCells());

        SudokuCell[][] solvedSudokuCells = sudokuSolver.getSolvedSudokuCells();
        System.out.println(getColoredText("Solved sudoku", GREEN, true, true));
        printSudoku(solvedSudokuCells);

        assertTrue(isSudokuValid(solvedSudokuCells));
        assertTrue(isSudokuSolved(solvedSudokuCells));
    }

    @Test
    void sudokuSolverTest2() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells2());
    }

    @Test
    void sudokuSolverTest3() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells3());
    }

    @Test
    void sudokuSolverTest4() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells4());
    }

    @Test
    void sudokuSolverTest5() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells5());
    }

    @Test
    void sudokuSolverTest6() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells6());
    }
    @Test
    void sudokuSolverTest7() {
        assertSudokuValidAndValidateSolution(initializeSudokuCells7());
    }

}