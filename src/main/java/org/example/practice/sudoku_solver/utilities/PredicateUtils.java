package org.example.practice.sudoku_solver.utilities;

import org.example.practice.sudoku_solver.SudokuCell;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.practice.sudoku_solver.utilities.SudokuUtils.getSudokuCell;


public class PredicateUtils {
    private PredicateUtils() {
    }

    public static Predicate<Integer> coordinatesInRange() {
        return value -> Objects.nonNull(value) && (value >= 0 && value < 9);
    }

    @NotNull
    public static IntPredicate isNumberLocationValidIntPredicate(SudokuCell[][] sudokuCells) {
        return isRowValidIntPredicate(sudokuCells)
                .and(isColumnValidIntPredicate(sudokuCells))
                .and(isBoxValidIntPredicate(sudokuCells));
    }

    @NotNull
    public static IntPredicate isBoxValidIntPredicate(SudokuCell[][] sudokuCells) {
        return boxNumber -> areAllCelledValuesUniqueWithinBox(sudokuCells, boxNumber);
    }

    private static boolean areAllCelledValuesUniqueWithinBox(SudokuCell[][] sudokuCells, int boxNumber) {
        return IntStream.range(0, 9)
                        .mapToObj(getCelledValueIntFunction(sudokuCells, boxNumber))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet()).size() ==

                IntStream.range(0, 9)
                         .mapToObj(getCelledValueIntFunction(sudokuCells, boxNumber))
                         .filter(Objects::nonNull)
                         .toList().size();
    }

    @NotNull
    private static IntFunction<Integer> getCelledValueIntFunction(SudokuCell[][] sudokuCells, int box) {
        return cellInternalNumber ->
                getSudokuCell(
                        sudokuCells, box,
                        cellInternalNumber
                             ).getValue();
    }

    @NotNull
    public static IntPredicate isColumnValidIntPredicate(SudokuCell[][] sudokuCells) {
        return column ->
                IntStream.range(0, 9)
                         .mapToObj(index -> sudokuCells[index][column].getValue())
                         .filter(Objects::nonNull).collect(Collectors.toSet()).size() ==
                        IntStream.range(0, 9)
                                 .mapToObj(index -> sudokuCells[index][column].getValue())
                                 .filter(Objects::nonNull).toList().size();

    }

    @NotNull
    public static IntPredicate isRowValidIntPredicate(SudokuCell[][] sudokuCells) {
        return row -> (
                IntStream.range(0, 9)
                         .mapToObj(index -> sudokuCells[row][index].getValue())
                         .filter(Objects::nonNull).collect(Collectors.toSet()).size() ==

                        IntStream.range(0, 9)
                                 .mapToObj(index -> sudokuCells[row][index].getValue())
                                 .filter(Objects::nonNull).toList().size()
        );
    }

    @NotNull
    public static IntPredicate areRowColumnBoxSolvedIntPredicate(SudokuCell[][] sudokuCells) {
        return isRowSolvedIntPredicate(sudokuCells).and(isColumnSolved(sudokuCells)).and(
                isBoxSolvedIntPredicate(sudokuCells));
    }

    @NotNull
    public static IntPredicate isRowSolvedIntPredicate(SudokuCell[][] sudokuCells) {
        return row -> (
                IntStream.range(0, 9)
                         .mapToObj(index -> sudokuCells[row][index].getValue())
                         .filter(Objects::nonNull)
                         .filter(value -> isValueValidAndInRange().test(value))
                         .collect(Collectors.toSet()).size() == 9
        );
    }

    public static Predicate<Integer> isValueValidAndInRange() {
        return value -> Objects.nonNull(value) && (value >= 1 && value <= 9);
    }

    @NotNull
    public static IntPredicate isColumnSolved(SudokuCell[][] sudokuCells) {
        return column -> (
                IntStream.range(0, 9)
                         .mapToObj(index -> sudokuCells[index][column].getValue())
                         .filter(Objects::nonNull)
                         .filter(value -> isValueValidAndInRange().test(value))
                         .collect(Collectors.toSet()).size() == 9
        );
    }

    @NotNull
    public static IntPredicate isBoxSolvedIntPredicate(SudokuCell[][] sudokuCells) {
        return box -> (
                IntStream.range(0, 9)
                         .mapToObj(getCelledValueIntFunction(sudokuCells, box)
                                  )
                         .filter(Objects::nonNull)
                         .filter(value -> isValueValidAndInRange().test(value))
                         .collect(Collectors.toSet()).size() == 9
        );
    }
}
