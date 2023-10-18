package org.example.practice.codility;

import static org.example.practice.codility.CellType.BLOCKED;

public class Cell {
    private int row;
    private int col;
    private CellType type;
    private boolean visited;
    private int localAreaNumber;

    public Cell(int row, int col, CellType type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.visited = false;
        this.localAreaNumber = -1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getType() {
        return type;
    }

    public int getLocalAreaNumber() {
        return localAreaNumber;
    }

    public void setLocalAreaNumber(int localAreaNumber) {
        this.localAreaNumber = localAreaNumber;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void markVisited() {
        this.visited = true;
    }

    public boolean needTraversal() {
        return type != BLOCKED && !visited;
    }
}
