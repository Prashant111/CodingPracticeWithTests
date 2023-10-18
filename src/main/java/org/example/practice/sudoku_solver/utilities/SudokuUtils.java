package org.example.practice.sudoku_solver.utilities;

import org.example.practice.sudoku_solver.SudokuCell;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.example.practice.sudoku_solver.validation.SudokuValidation.validateDimensions;

public class SudokuUtils {
    private SudokuUtils() {

    }

    public static SudokuCell[][] getSudokuCellsCopy(final SudokuCell[][] originalSudokuCells) {
        validateDimensions(originalSudokuCells);
        SudokuCell[][] sudokuCellsCopy = new SudokuCell[originalSudokuCells.length][originalSudokuCells[0].length];
        for (int i = 0; i < originalSudokuCells.length; i++) {
            for (int j = 0; j < originalSudokuCells[i].length; j++) {
                sudokuCellsCopy[i][j] = getSudokuCellCopy(originalSudokuCells[i][j]);
            }
        }
        return sudokuCellsCopy;
    }

    private static SudokuCell getSudokuCellCopy(SudokuCell sudokuCell) {
        Integer value = sudokuCell.getValue();
        return getSudokuCellValue(sudokuCell.getX(), sudokuCell.getY(), value);
    }

    @NotNull
    public static SudokuCell getSudokuCellValue(int x, int y, Integer value) {
        return Objects.nonNull(value)
                ? new SudokuCell(x, y, value)
                : new SudokuCell(x, y);
    }

    public static SudokuCell getSudokuCell(SudokuCell[][] sudokuCells, Integer box, int cellInternalNumber) {
        int x = (box / 3) * 3 + cellInternalNumber / 3;
        int y = (box % 3) * 3 + cellInternalNumber % 3;
        return sudokuCells[x][y];
    }

}
