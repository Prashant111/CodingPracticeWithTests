package org.example.practice.sudoku_solver;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

import static java.awt.Color.BLUE;
import static org.example.utilities.ColorUtils.getBoldText;
import static org.example.utilities.StringUtils.SINGLE_SPACE;

public class SudokuSolverPrinter {

    public static final String EMPTY_FIELD = ".";

    private SudokuSolverPrinter() {
    }

    public static void printSudoku(SudokuCell[][] sudokuCells) {
        System.out.println("---------------------");
        for (int i = 0; i < sudokuCells.length; i++) {
            for (int j = 0; j < sudokuCells[i].length; j++) {
                Integer value = sudokuCells[i][j].getValue();
                boolean isPrefilled = sudokuCells[i][j].isPrefilled();
                System.out.print(getCharacterToPrint(value, isPrefilled));
                if (j % 3 == 2)
                    System.out.print("|");
            }
            System.out.println();
            if (i % 3 == 2)
                System.out.println("---------------------");
        }
    }

    @NotNull
    private static String getCharacterToPrint(Integer value, boolean isPrefilled) {
        String printableText = isPrefilled ? getBoldText(String.valueOf(value), BLUE) : String.valueOf(value);
        String printableCharacter = Objects.isNull(value) ? EMPTY_FIELD : printableText;
        return printableCharacter.concat(SINGLE_SPACE);
    }
}
