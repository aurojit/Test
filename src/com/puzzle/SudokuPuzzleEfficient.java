package com.puzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class SudokuPuzzleEfficient {

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

        List<Integer> unfilledList = null;
        boolean isReturnUniqueSetListMethodTraversed = false;
        while (true) {

            if (!isReturnUniqueSetListMethodTraversed)
                unfilledList = returnUniqueSetList(sudokuboard, i, j);

            isReturnUniqueSetListMethodTraversed = true;

            int unfilledListSize = unfilledList.size();

            if (0 != unfilledListSize) {
                int randomNumber = randomNumberGenerator(unfilledList);

                dataSet.add(randomNumber);

                sudokuboard[i][j] = randomNumber;

                if (nSudokuSolver(sudokuboard, i, j + 1))
                    return true;

                sudokuboard[i][j] = 0;
                System.out.println("********************BACKTRACK**************************");

            }

            if (0 == unfilledListSize || unfilledListSize == dataSet.size())
                break;
        }

        return false;
    }

    /**
     * Generate random number
     *
     * @return return random number
     */
    private static int randomNumberGenerator(List<Integer> unfilledList) {
        randomCount++;
        return unfilledList.get(random.nextInt(unfilledList.size()));
    }

    /**
     * @param sudokuboard sudokuboard
     * @param row row
     * @param col col
     * @return return
     */
    private static List<Integer> returnUniqueSetList(int[][] sudokuboard, int row, int col) {
        returnUniqueSetListMethodCount++;
        Set<Integer> filledSet = new HashSet<>();
        List<Integer> unfilledList = new ArrayList<>();

        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {

            if (0 != sudokuboard[row][i]) {
                filledSet.add(sudokuboard[row][i]);
            }
            if (0 != sudokuboard[i][col]) {
                filledSet.add(sudokuboard[i][col]);
            }
        }
        for (int i = 1; i <= SUDOKU_BOARD_SIZE; i++) {
            if (!filledSet.contains(i)) {
                unfilledList.add(i);
            }
        }
        return unfilledList;
    }

    /**
     * Print Sudoku Board.
     *
     * @param sudokuboard sudokuboard
     */
    private static void printSudokuBoard(int[][] sudokuboard) {
        System.out.println("***********************************");
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
