package org.example.practice.sudoku_solver;

import java.util.Objects;

import static org.example.practice.sudoku_solver.utilities.SudokuUtils.getSudokuCellValue;

public class BaseSudokuSolverTest {
    private static SudokuCell getCellValue(SudokuCell[][] sudokuCells, int x, int y, Integer value) {
        return Objects.isNull(value) ? new SudokuCell(x, y) : new SudokuCell(x, y, value);
    }

    protected SudokuCell[][] initializeSudokuCells1() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {null, 4, null,},
                                {2, null, 3},
                                {9, 7, null}
                        },
                        {
                                {6, null, null},
                                {null, null, 9},
                                {null, 4, 3}
                        },
                        {
                                {null, null, 3},
                                {null, 4, null},
                                {null, null, null},
                        }
                },
                {
                        {
                                {null, 6, 5},
                                {null, null, null},
                                {null, 8, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },

                        {
                                {null, 2, null},
                                {null, null, null},
                                {1, 3, null}}
                },
                {

                        {
                                {null, null, null},
                                {null, 2, null},
                                {null, null, null}
                        },
                        {
                                {4, 6, null},
                                {9, null, null},
                                {null, null, 5}
                        },
                        {
                                {null, 8, 7},
                                {3, null, 5},
                                {null, 1, null}
                        }
                }
        });
        return sudokuCells;
    }

    private void setSection(SudokuCell[][] sudokuCells, Integer[][][][] integers) {
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers[i].length; j++) {
                for (int k = 0; k < integers[j].length; k++) {
                    for (int l = 0; l < integers[k].length; l++) {
                        int row = i * 3 + k;
                        int column = j * 3 + l;
                        sudokuCells[row][column] = getSudokuCellValue(row, column, integers[i][j][k][l]);
                    }
                }
            }
        }
    }

    protected SudokuCell[][] initializeSudokuCells2() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {null, null, null,},
                                {null, 3, null},
                                {null, 2, 6}
                        },
                        {
                                {5, null, 8},
                                {null, null, null},
                                {9, null, 4}
                        },
                        {
                                {null, null, null},
                                {null, 9, null},
                                {8, 7, null}
                        },
                },
                {
                        {
                                {8, 4, null},
                                {null, null, null},
                                {1, 5, null}
                        },
                        {
                                {null, null, null},
                                {4, null, 7},
                                {null, null, null}
                        },
                        {
                                {null, 5, 7},
                                {null, null, null},
                                {null, 3, 6}
                        }
                },
                {
                        {
                                {null, 7, 5},
                                {null, 6, null},
                                {null, null, null}
                        },
                        {
                                {2, null, 6},
                                {null, null, null},
                                {7, null, 1}
                        },
                        {
                                {3, 4, null},
                                {null, 8, null},
                                {null, null, null}
                        }
                }
        });
        return sudokuCells;
    }

    protected SudokuCell[][] initializeSudokuCells3() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                },
                {
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                },
                {
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                }
        });
        return sudokuCells;
    }

    protected SudokuCell[][] initializeSudokuCells4() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {8, null, null},
                                {5, null, null},
                                {null, 2, null}
                        },
                        {
                                {null, null, null},
                                {null, 8, null},
                                {5, null, null}
                        },
                        {
                                {null, null, 4},
                                {null, 1, 7},
                                {null, null, null}
                        },
                },
                {
                        {
                                {null, null, 6},
                                {2, null, null},
                                {null, null, null}
                        },
                        {
                                {null, null, 9},
                                {null, 7, null},
                                {null, null, null}
                        },
                        {
                                {null, null, null},
                                {null, 8, 5},
                                {3, null, null}
                        },
                },
                {
                        {
                                {null, null, null},
                                {1, null, null},
                                {null, 9, null}
                        },
                        {
                                {null, 3, null},
                                {null, null, null},
                                {null, null, 7}
                        },
                        {
                                {2, null, null},
                                {4, null, null},
                                {null, 3, 1}
                        },
                }
        });
        return sudokuCells;
    }

    protected SudokuCell[][] initializeSudokuCells5() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {1, 9, null},
                                {null, null, null},
                                {null, null, 5}
                        },
                        {
                                {null, null, 7},
                                {null, null, null},
                                {4, null, null}
                        },
                        {
                                {null, null, null},
                                {null, 6, null},
                                {3, null, 8}
                        },
                },
                {
                        {
                                {null, 5, null},
                                {null, null, 6},
                                {null, null, null}
                        },
                        {
                                {null, 9, null},
                                {null, null, null},
                                {1, null, null}
                        },
                        {
                                {1, null, 6},
                                {null, 4, null},
                                {null, 2, null}
                        },
                },
                {
                        {
                                {null, null, null},
                                {3, null, null},
                                {null, null, 8}
                        },
                        {
                                {null, null, null},
                                {null, 4, null},
                                {3, null, null}
                        },
                        {
                                {2, null, null},
                                {null, null, null},
                                {5, null, 1}
                        },
                }
        });
        return sudokuCells;
    }
protected SudokuCell[][] initializeSudokuCells6() {
        SudokuCell[][] sudokuCells = new SudokuCell[9][9];
        setSection(sudokuCells, new Integer[][][][]{
                {
                        {
                                {null, null, 4},
                                {null, null, null},
                                {8, null, null}
                        },
                        {
                                {9, 3, null},
                                {null, null, null},
                                {1, null, null}
                        },
                        {
                                {null, 6, 7},
                                {9, null, null},
                                {null, null, null}
                        },
                },
                {
                        {
                                {null, null, null},
                                {null, null, 5},
                                {null, 1, null}
                        },
                        {
                                {null, 9, null},
                                {null, null, null},
                                {3, null, null}
                        },
                        {
                                {4, null, null},
                                {2, null, null},
                                {null, 5, 9}
                        },
                },
                {
                        {
                                {null, null, 6},
                                {null, null, null},
                                {null, 4, null}
                        },
                        {
                                {null, 7, null},
                                {null, null, null},
                                {null, null, 6}
                        },
                        {
                                {null, 3, 5},
                                {null, 2, null},
                                {null, null, null}
                        },
                }
        });
        return sudokuCells;
    }

}
