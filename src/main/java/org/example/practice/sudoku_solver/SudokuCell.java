package org.example.practice.sudoku_solver;

import static org.example.practice.sudoku_solver.CellState.*;
import static org.example.practice.sudoku_solver.validation.SudokuValidation.*;

public class SudokuCell {
    private final int x;
    private final int y;
    private Integer value;
    private CellState cellState;

    public SudokuCell(final int x, final int y, final int value) {
        validateInput(x, y, value);
        this.x = x;
        this.y = y;
        this.cellState = CellState.PREFILLED;
        this.value = value;
    }

    private void validateInput(int x, int y, int value) {
        validateCoordinates(x, y);
        validateValue(value, x, y);
    }

    public SudokuCell(final int x, final int y) {
        validateCoordinates(x, y);
        this.x = x;
        this.y = y;
        this.cellState = EMPTY;
        this.value = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        validateIfFieldWritable(cellState, x, y);
        validateValue(value, x, y);

        this.value = value;
        this.cellState = FILLED;
    }


    public void clearValue() {
        validateIfFieldWritable(cellState, x, y);
        this.value = null;
        this.cellState = EMPTY;
    }

    public boolean isAvailableToWrite() {
        return cellState == EMPTY;
    }

    public boolean isPrefilled() {
        return cellState == PREFILLED;
    }
}
