package org.example.practice.sudoku_solver;

import org.example.practice.sudoku_solver.exceptions.SudokuNotSolvableException;

import static org.example.practice.sudoku_solver.utilities.SudokuUtils.getSudokuCellsCopy;
import static org.example.practice.sudoku_solver.validation.SudokuValidation.*;

public class SudokuSolver {
    private final SudokuCell[][] sudokuCells;

    public SudokuSolver(SudokuCell[][] sudokuCells) {
        validateSudokuCells(sudokuCells);
        this.sudokuCells = sudokuCells;
    }

    public SudokuCell[][] getSolvedSudokuCells() {
        validateValues();
        SudokuCell[][] sudokuCellsCopy = getSudokuCellsCopy(sudokuCells);
        boolean solvable = sudokuSolverHelper(sudokuCellsCopy, 0, 0);
        if (!solvable) {
            throw new SudokuNotSolvableException();
        }
        return sudokuCellsCopy;
    }

    public SudokuCell[][] getSudokuCells() {
        return sudokuCells;
    }

    private boolean sudokuSolverHelper(SudokuCell[][] sudokuCells, int x, int y) {
        if (x >= 9) {
            return true;
        }
        if (y >= 9) {
            return sudokuSolverHelper(sudokuCells, x + 1, 0);
        }
        SudokuCell sudokuCell = sudokuCells[x][y];
        if (!sudokuCell.isAvailableToWrite()) {
            return sudokuSolverHelper(sudokuCells, x, y + 1);
        }

        for (int i = 1; i <= 9; i++) {
            sudokuCell.setValue(i);
            if (isNumberValidOnCoordinate(sudokuCells, x, y)
                    && sudokuSolverHelper(sudokuCells, x, y + 1)
            ) {
                return true;
            }
            sudokuCell.clearValue();
        }
        return false;
    }

    boolean validateValues() {
        return isSudokuValid(sudokuCells);
    }
}
