package com.puzzle;

import java.util.Set;
import java.util.Random;
import java.util.HashSet;

/**
 * This is a sudoku puzzle solving.
 *
 * @author Aurojit
 */
public class SudokuPuzzle {

    public static int count = 0;
    public static final int SUDOKU_GRID_SIZE = 9;
    public static final Random random = new Random();

    public static void main(String[] args) {

        Set<Integer> dataSet = new HashSet<>();

        int[][] sudoku = new int[SUDOKU_GRID_SIZE][SUDOKU_GRID_SIZE];


        for (int i = 0; i < SUDOKU_GRID_SIZE; i++) {

            for (int j = 0; j < SUDOKU_GRID_SIZE; j++) {

                for (int k = 0; k < j; k++) {
                    dataSet.add(sudoku[i][k]);
                }
                for (int k = 0; k < i; k++) {
                    dataSet.add(sudoku[k][j]);
                }
                int num = randomNumberGenerator(dataSet);
                if (0 == num) {
                    j = 0;
                    dataSet.clear();
                    continue;
                } else {
                    sudoku[i][j] = num;
                }
                dataSet.clear();
            }
        }

        printSudoku(sudoku);
    }

    /**
     * Random number generation.
     *
     * @param dataSet dataSet
     * @return return
     */
    private static int randomNumberGenerator(Set<Integer> dataSet) {
        int number = 0;
        if (dataSet.size() != SUDOKU_GRID_SIZE) {
            do {
                count++;
                number = random.nextInt(SUDOKU_GRID_SIZE + 1);
            } while (dataSet.contains(number) || number <= 0);
        }
        return number;
    }

    /**
     * Printing sudoku numbers.
     *
     * @param sudoku sudoku
     */
    private static void printSudoku(int[][] sudoku) {
        System.out.println("Count:" + count);
        System.out.println("\nPrinting Sudoku:\n");
        for (int i = 0; i < SUDOKU_GRID_SIZE; i++) {
            for (int j = 0; j < SUDOKU_GRID_SIZE; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}
