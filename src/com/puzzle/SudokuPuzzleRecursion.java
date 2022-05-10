package com.puzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SudokuPuzzleRecursion {

    public static int randomCount = 0;
    public static int returnUniqueSetListMethodCount = 0;
    public static final int SUDOKU_BOARD_SIZE = 9;
    public static final Random random = new Random();

    /**
     * Sudoku-Puzzle problem starts here.
     *
     * @param args Empty command line argument.
     */
    public static void main(String[] args) {
        int[][] sudokuboard = new int[SUDOKU_BOARD_SIZE][SUDOKU_BOARD_SIZE];

        initializedSudokuBoard(sudokuboard);
        printSudokuBoard(sudokuboard);
        if (!nSudokuSolver(sudokuboard, 0, 0)) {
            System.out.println("Solution not possible");
        } else {
            printSudokuBoard(sudokuboard);
        }
        System.out.println("RandomCount: " + randomCount);
        System.out.println("ReturnUniqueSetListMethodCount: " + returnUniqueSetListMethodCount);
    }

    /**
     * Main Logic of Sudoku using back-tracking
     *
     * @param sudokuboard sudokuboard
     * @param i           Row
     * @param j           Column
     * @return return boolean : solution is possible or not
     */
    private static boolean nSudokuSolver(int[][] sudokuboard, int i, int j) {

        Set<Integer> dataSet = new HashSet<>();

        if (j == SUDOKU_BOARD_SIZE) {
            i = i + 1;
            j = 0;
        }

        if (i == SUDOKU_BOARD_SIZE)
            return true;

        while (true) {

            int randomNumber = randomNumberGenerator();

            dataSet.add(randomNumber);

            if (canRandomNumberBePlaced(sudokuboard, i, j, randomNumber)) {
                sudokuboard[i][j] = randomNumber;
                if (nSudokuSolver(sudokuboard, i, j + 1))
                    return true;

                sudokuboard[i][j] = 0;
            }

            if (SUDOKU_BOARD_SIZE == dataSet.size())
                break;
        }
        return false;
    }

    /**
     * Generate random number
     *
     * @return return random number
     */
    private static int randomNumberGenerator() {
        int randomNumber;
        do {
            randomCount++;
            randomNumber = random.nextInt(SUDOKU_BOARD_SIZE + 1);
        } while (randomNumber <= 0);
        return randomNumber;
    }

    /**
     * Logic of if the random number can be placed or not on a given co-ordinate.
     *
     * @param sudokuboard  sudokuboard
     * @param row          row
     * @param col          col
     * @param randomNumber randomNumber
     * @return return
     */
    private static boolean canRandomNumberBePlaced(int[][] sudokuboard, int row, int col, int randomNumber) {
        returnUniqueSetListMethodCount++;
        if (0 != sudokuboard[row][col])
            return false;

        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            if (sudokuboard[row][i] == randomNumber || sudokuboard[i][col] == randomNumber) {
                return false;
            }
        }

        return true;
    }


    /**
     * Print Sudoku Board.
     *
     * @param sudokuboard sudokuboard
     */
    private static void printSudokuBoard(int[][] sudokuboard) {
        System.out.println("***************************************");
        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (int j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                System.out.printf("%4d", sudokuboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialized the Sudoku Board.
     *
     * @param sudokuboard sudokuboard
     */
    private static void initializedSudokuBoard(int[][] sudokuboard) {
        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (int j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                sudokuboard[i][j] = 0;
            }
        }
    }
}
