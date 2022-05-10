package com.puzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a Sudoku Puzzle Game written in java.
 * Environment Requirement : Only Java-8 runtime environment is needed to play this game.
 * Please play this game and enjoy.
 *
 * @author Aurojit Basak
 * @version 1.0
 * @implNote This problem has been solved by Back-Tracking Algorithm (using Recursion).
 * @since 08.08.2020
 */
public class PlaySudokuPuzzleGame {

    /**
     * SUDOKU_BOARD_SIZE : SUDOKU_BOARD_SIZE is a variable which defines the Sudoku Board size.
     * Here SUDOKU_BOARD_SIZE is : 9 * 9
     */
    public static final int SUDOKU_BOARD_SIZE = 9;

    /**
     * random : random is a java.util.Random Object.
     * This Object is needed to produce Random number.
     */
    public static final Random random = new Random();

    /**
     * SUDOKU_LEVEL : This variable defines the Level of hardness of Sudoku
     * SUDOKU_LEVEL EASY : Give any number from 1 to 2.
     * SUDOKU_LEVEL MODERATE : Give any number from 3 to 4.
     * SUDOKU_LEVEL HARD : Give any number from 5 to 7.
     * Here SUDOKU_LEVEL is 1. That means you are playing Sudoku in Easy Level
     */
    public static byte SUDOKU_LEVEL;

    /**
     * Scanner is used to take user input.
     */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Sudoku-Puzzle game starts here.
     * Please play
     *
     * @param args Empty command line argument.
     */
    public static void main(String[] args) {
        int[][] sudokuboard = new int[SUDOKU_BOARD_SIZE][SUDOKU_BOARD_SIZE];
        int[][] sudokuPlayBoard = new int[SUDOKU_BOARD_SIZE][SUDOKU_BOARD_SIZE];

        initializedSudokuBoard(sudokuboard);
        if (!nSudokuSolver(sudokuboard, 0, 0)) {
            System.out.println("Solution not possible");
        } else {
            copySolvedSudokuToPlaySudoku(sudokuboard, sudokuPlayBoard);
            generateSudokuBoardToPlay(sudokuPlayBoard);
            printSudokuBoard(sudokuPlayBoard);
            giveAnswer(sudokuPlayBoard);
            System.out.println();
            boolean isEqual = checkEqualityOfTwoBoard(sudokuboard, sudokuPlayBoard);
            if (isEqual)
                System.out.println("!!!!!!!!!!!!!!!!!-You WIN-!!!!!!!!!!!!!!!!!");
            else
                System.out.println("!!!!!!!!!!!!!!!!!-You LOSE-!!!!!!!!!!!!!!!!!");

            System.out.println("***************Solution******************");
            printSudokuBoard(sudokuboard);
        }
    }

    /**
     * Provide the answer
     *
     * @param sudokuPlayBoard sudokuPlayBoard
     */
    private static void giveAnswer(int[][] sudokuPlayBoard) {
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (byte j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                if (0 == sudokuPlayBoard[i][j]) {
                    System.out.print("Provide input in position :(" + i + "," + j + ") :");
                    sudokuPlayBoard[i][j] = Integer.parseInt(scanner.next());
                }
            }
        }
    }

    /**
     * Checking equality of two board question and solution board.
     *
     * @param sudokuboard     sudokuboard is solution board
     * @param sudokuPlayBoard sudokuPlayBoard is question board
     * @return return true or false : sudoku is solved or not ?
     */
    private static boolean checkEqualityOfTwoBoard(int[][] sudokuboard, int[][] sudokuPlayBoard) {
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (byte j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                if (!(sudokuboard[i][j] == sudokuPlayBoard[i][j])) {
                    System.out.println("Wrong input in position :(" + i + "," + j + "): " + sudokuPlayBoard[i][j]);
                    System.out.println("Correct Number will be : " + sudokuboard[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method determine SUDOKU LEVEL as per user input.
     */
    private static void sudokuLevel() {
        System.out.println("************************ SUDOKU LEVELS ************************");
        System.out.println("Press 1 : SUDOKU LEVEL BEGINNER");
        System.out.println("Press 2 : SUDOKU LEVEL EASY");
        System.out.println("Press 3 : SUDOKU LEVEL MEDIUM");
        System.out.println("Press 4 : SUDOKU LEVEL MODERATE");
        System.out.println("Press 5 : SUDOKU LEVEL HARD");
        System.out.println("Press 6 : SUDOKU LEVEL VERY HARD");
        System.out.println("Press 7 : SUDOKU LEVEL VERY DIFFICULT AND TRICKY");
        System.out.println("Press 8 : SUDOKU LEVEL ALMOST IMPOSSIBLE");
        System.out.println("Press 9 : SUDOKU LEVEL TOTALLY IMPOSSIBLE");
        System.out.println("************************ SUDOKU LEVELS ************************");
        System.out.print("Please choose level : ");
        SUDOKU_LEVEL = Byte.parseByte(scanner.next());
        if (!(SUDOKU_LEVEL >= 1 && SUDOKU_LEVEL <= 9))
            throw new RuntimeException("Invalid SUDOKU LEVEL: " + SUDOKU_LEVEL);
    }

    /**
     * Generate sudoku play board with level (Easy, Moderate, Hard)
     *
     * @param sudokuPlayBoard sudokuPlayBoard
     */
    private static void generateSudokuBoardToPlay(int[][] sudokuPlayBoard) {
        sudokuLevel();
        System.out.println("Your selected SUDOKU LEVEL is = " + SUDOKU_LEVEL);
        System.out.println("************************ BEST OF LUCK ************************");
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (byte j = 0; j < SUDOKU_LEVEL; j++) {
                sudokuPlayBoard[i][randomNumberGenerator()] = 0;
            }
        }
    }

    /**
     * Make a copy of solution board
     *
     * @param sudokuboard     sudokuboard
     * @param sudokuPlayBoard sudokuPlayBoard
     */
    private static void copySolvedSudokuToPlaySudoku(int[][] sudokuboard, int[][] sudokuPlayBoard) {
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            System.arraycopy(sudokuboard[i], 0, sudokuPlayBoard[i], 0, SUDOKU_BOARD_SIZE);
        }
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

                sudokuboard[i][j] = 0;  //BACKTRACK
                //System.out.println("********************BACKTRACK**************************");
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
        return unfilledList.get(random.nextInt(unfilledList.size()));
    }

    /**
     * Generate random number
     *
     * @return return random number
     */
    private static int randomNumberGenerator() {
        return random.nextInt(SUDOKU_BOARD_SIZE);
    }

    /**
     * This method will generate a list of unique value which are not present in Row, Column and 3 * 3 little box.
     *
     * @param sudokuboard sudokuboard
     * @param row         row
     * @param col         col
     * @return return
     */
    private static List<Integer> returnUniqueSetList(int[][] sudokuboard, int row, int col) {
        Set<Integer> filledSet = new HashSet<>();
        List<Integer> unfilledList = new ArrayList<>();

        for (int i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            filledSet.add(sudokuboard[row][i]);
            filledSet.add(sudokuboard[i][col]);
        }
        int j = (row / 3) * 3;
        int k = (col / 3) * 3;
        int n = j + 3;
        int m = k + 3;

        for (; j < n; j++) {
            for (k = (col / 3) * 3; k < m; k++) {
                filledSet.add(sudokuboard[j][k]);
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
        System.out.println("*******************************************");
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (byte j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                if (0 == sudokuboard[i][j])
                    System.out.print("   _");
                else
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
        for (byte i = 0; i < SUDOKU_BOARD_SIZE; i++) {
            for (byte j = 0; j < SUDOKU_BOARD_SIZE; j++) {
                sudokuboard[i][j] = 0;
            }
        }
    }
}
