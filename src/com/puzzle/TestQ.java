package com.puzzle;

public class TestQ {
    public static final int SUDOKU_BOARD_SIZE = 9;

    public static void main(String[] args) {
        String[][] sudokuboard = new String[SUDOKU_BOARD_SIZE][SUDOKU_BOARD_SIZE];
        int number = 3;
        int div = number / 3;
        int remainder = number % 3;

        System.out.println("div = " + div);
        System.out.println("remainder = " + remainder);
        initializedSudokuBoard(sudokuboard);
        printSudokuBoard(sudokuboard);
        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (int j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                sudokuboard[i][j] = "(" + ((i / 3) * 3) + "," + ((j / 3) * 3) + ")";
            }
        }
        printSudokuBoard(sudokuboard);
    }


    /**
     * Print Sudoku Board.
     *
     * @param sudokuboard sudokuboard
     */
    private static void printSudokuBoard(String[][] sudokuboard) {
        System.out.println("***********************************");
        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (int j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                System.out.print(" " + sudokuboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialized the Sudoku Board.
     *
     * @param sudokuboard sudokuboard
     */
    private static void initializedSudokuBoard(String[][] sudokuboard) {
        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (int j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                sudokuboard[i][j] = "A";
            }
        }
    }
}
