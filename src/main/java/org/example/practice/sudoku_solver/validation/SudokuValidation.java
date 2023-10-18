package org.example.practice.sudoku_solver.validation;

import org.example.practice.sudoku_solver.CellState;
import org.example.practice.sudoku_solver.SudokuCell;
import org.example.practice.sudoku_solver.exceptions.InvalidCoordinatesException;
import org.example.practice.sudoku_solver.exceptions.InvalidDimensionsException;
import org.example.practice.sudoku_solver.exceptions.InvalidValueException;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.example.practice.sudoku_solver.CellState.PREFILLED;
import static org.example.practice.sudoku_solver.utilities.PredicateUtils.*;

public class SudokuValidation {
    private SudokuValidation() {
    }


    public static void validateSudokuCells(SudokuCell[][] sudokuCells) {
        validateDimensions(sudokuCells);
        isSudokuValid(sudokuCells);
    }

    public static void validateDimensions(SudokuCell[][] sudokuCells) {
        if (Objects.isNull(sudokuCells) || sudokuCells.length != 9 || sudokuCells[0].length != 9) {
            String incorrectDimensionErrorMessage = Objects.isNull(sudokuCells) ? "Null cells" : String.format(
                    "[%d, %d]", sudokuCells.length, sudokuCells[0].length);

            throw new InvalidDimensionsException(
                    String.format("Sudoku dimensions : %s", incorrectDimensionErrorMessage));
        }
    }

    public static boolean isSudokuValid(SudokuCell[][] sudokuCells) {
        return IntStream
                .range(0, 9)
                .allMatch(isNumberLocationValidIntPredicate(sudokuCells));
    }

    public static boolean isSudokuSolved(SudokuCell[][] sudokuCells) {
        return IntStream
                .range(0, 9)
                .allMatch(areRowColumnBoxSolvedIntPredicate(sudokuCells));
    }

    public static void validateIfFieldWritable(CellState cellState, int x, int y) {
        if (cellState.equals(PREFILLED)) {
            throw new InvalidDimensionsException(String.format("Can not override at location (%d, %d)", x, y));
        }
    }

    public static boolean isNumberValidOnCoordinate(SudokuCell[][] sudokuCells, int x, int y) {
        return isRowValidIntPredicate(sudokuCells).test(x)
                && isColumnValidIntPredicate(sudokuCells).test(y)
                && isBoxValidIntPredicate(sudokuCells).test((x / 3) * 3 + y / 3);
    }

    public static void validateCoordinates(int x, int y) {
        if (!areSudokuCoordinatesValid(x, y)) {
            throw new InvalidCoordinatesException(String.format("(%d, %d)", x, y));
        }
    }

    public static boolean areSudokuCoordinatesValid(int x, int y) {
        return areCoordinatesValid(x, y);
    }

    private static boolean areCoordinatesValid(int... field) {
        return Arrays.stream(field).allMatch(coordinatesInRange()::test);
    }

    public static void validateValue(int value, int x, int y) {
        if (!isValueValid(value)) {
            throw new InvalidValueException(String.format("Invalid value %d in sudoku: (%d, %d)", value, x, y));
        }
    }

    public static boolean isValueValid(int value) {
        return isValueValidAndInRange().test(value);
    }
}
