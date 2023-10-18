package org.example.practice.codility;

import java.util.*;

import static org.example.practice.codility.CellType.*;

public class MinimumRobots {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "##.*#.*",
                "##.##.*",
                "#*.####",
                "##.####",
                "###.###",
                "##.##..",
                "*..*#..",
                "###*###"
        };
        System.out.println("countNumberOfRobots(strings) = " + countNumberOfRobots(strings));

    }

    public static int countNumberOfRobots(String[] lists) {
        int row = lists.length;
        int col = lists[0].length();

        Cell[][] cells = getCellsConverted(lists);
        List<Cell> dirtyCells = getDirtyCells(cells);

        updateCells(cells, dirtyCells);

        print(cells);
        printCellIds(cells);

        int countNonNegativeNumber = getLocalAreas(cells);
        System.out.println("countNonNegativeNumber = " + countNonNegativeNumber);

        return countNonNegativeNumber;
    }

    private static int getLocalAreas(Cell[][] cells) {
        Set<Integer> localAreasSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                count = !localAreasSet.contains(
                        cells[i][j].getLocalAreaNumber()) && cells[i][j].getLocalAreaNumber() >= 0 ? count + 1 : count;
                localAreasSet.add(cells[i][j].getLocalAreaNumber());
            }

        }
        return count;
    }

    private static void printCellIds(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            System.out.println();
            for (int j = 0; j < cells[i].length; j++) {
                System.out.printf("%2d ", cells[i][j].getLocalAreaNumber());
            }
        }
        System.out.println();
    }

    private static void print(Cell[][] cells) {
        System.out.println();
        for (int i = 0; i < cells.length; i++) {
            System.out.println();
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(getCellTypeMap(cells[i][j].getType()) + " ");
            }
        }
        System.out.println();
    }

    private static String getCellTypeMap(CellType type) {
        return switch (type) {
            case EMPTY -> " ";
            case BLOCKED -> "X";
            case DIRTY -> ".";
        };
    }

    private static void updateCells(Cell[][] cells, List<Cell> dirtyCells) {
        int count = 0;
        for (int i = 0; i < dirtyCells.size(); i++) {
            int row = dirtyCells.get(i)
                                .getRow();
            int col = dirtyCells.get(i)
                                .getCol();
            dfs(cells, row, col, count++);
        }
    }

    private static void dfs(Cell[][] cells, int row, int col, int id) {
        if (row < 0 || row >= cells.length || col < 0 || col >= cells[0].length || !cells[row][col].needTraversal()) {
            return;
        }

        cells[row][col].markVisited();
        cells[row][col].setLocalAreaNumber(id);
        dfs(cells, row - 1, col, id);
        dfs(cells, row + 1, col, id);
        dfs(cells, row, col + 1, id);
        dfs(cells, row, col - 1, id);
    }

    private static List<Cell> getDirtyCells(Cell[][] cells) {
        List<Cell> dirtyCells = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getType() == DIRTY)
                    dirtyCells.add(cells[i][j]);
            }
        }
        return dirtyCells;
    }

    private static Map<String, Cell> getRowsColsCellsMap(Cell[][] cells) {
        Map<String, Cell> mapCell = new HashMap<>();

        return mapCell;
    }

    private static Cell[][] getCellsConverted(String[] lists) {
        Cell[][] cells = new Cell[lists.length][lists[0].length()];
        for (int i = 0; i < lists.length; i++) {
            char[] chars = lists[i].toCharArray();
            for (int j = 0; j < chars.length; j++)
                cells[i][j] = new Cell(i, j, getCellTypeFromCharacter(chars[j]));
        }
        return cells;
    }

    private static CellType getCellTypeFromCharacter(char type) {
        return switch (type) {
            case '.' -> EMPTY;
            case '*' -> DIRTY;
            case '#' -> BLOCKED;
            default -> null;
        };
    }
}
