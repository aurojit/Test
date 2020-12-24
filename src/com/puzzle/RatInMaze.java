package com.puzzle;

/**
 * This is a "Rat in a Maze" Game written in java.
 * Environment Requirement : Only Java-8 runtime environment is needed to play this game.
 * Please play this game and enjoy.
 *
 * @author Aurojit Basak
 * @version 1.0
 * @implNote This problem has been solved by Back-Tracking Algorithm (using Recursion).
 * @since 08.08.2020
 */
public class RatInMaze {

    public static final int BOARD_SIZE = 4;

    public static void main(String[] args) {
        int[][] problemMazeboard = {{1, 1, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}};
        int[][] soutionMazeBoard = new int[BOARD_SIZE][BOARD_SIZE];
        initializedSudokuBoard(soutionMazeBoard);
        int sourceX = 0;
        int sourceY = 0;
        int destX = 3;
        int destY = 3;
        soutionMazeBoard[sourceX][sourceY] = 1;
        nRatInMazeSolver(problemMazeboard, soutionMazeBoard, sourceX, sourceY, destX, destY);
        System.out.println("*************Problem****************");
        printSudokuBoard(problemMazeboard);
        System.out.println("*************Solution***************");
        printSudokuBoard(soutionMazeBoard);
    }

    /**
     * @param problemMazeboard problemMazeboard
     * @param soutionMazeBoard soutionMazeBoard
     * @param sourceX          sourceX
     * @param sourceY          sourceY
     * @param destX            destX
     * @param destY            destY
     * @return return
     */
    private static boolean nRatInMazeSolver(int[][] problemMazeboard, int[][] soutionMazeBoard, int sourceX, int sourceY, int destX, int destY) {

        if ((sourceX == destX) && (sourceY == destY))
            return true;

        int[] rows = {+1, +0, +0, -1};
        int[] cols = {+0, +1, -1, +0};

        for (int k = 0; k < 4; k++) {
            int nextX = sourceX + rows[k];
            int nextY = sourceY + cols[k];

            if (isPathExists(problemMazeboard, soutionMazeBoard, nextX, nextY)) {
                soutionMazeBoard[nextX][nextY] = 1;
                if (nRatInMazeSolver(problemMazeboard, soutionMazeBoard, nextX, nextY, destX, destY))
                    return true;

                soutionMazeBoard[nextX][nextY] = 0;
            }
        }
        return false;
    }

    /**
     * @param problemMazeboard problemMazeboard
     * @param soutionMazeBoard soutionMazeBoard
     * @param row              row
     * @param col              col
     * @return return
     */
    private static boolean isPathExists(int[][] problemMazeboard, int[][] soutionMazeBoard, int row, int col) {
        return (row >= 0 && row < BOARD_SIZE)
                && (col >= 0 && col < BOARD_SIZE)
                && problemMazeboard[row][col] == 1
                && soutionMazeBoard[row][col] == 0;
    }

    /**
     * Printing Maze Board.
     *
     * @param mazeboard mazeboard
     */
    private static void printSudokuBoard(int[][] mazeboard) {
        System.out.println("************************************");
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.printf("%4d", mazeboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialized the Maze Board.
     *
     * @param mazeboard mazeboard
     */
    private static void initializedSudokuBoard(int[][] mazeboard) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                mazeboard[i][j] = 0;
            }
        }
    }
}
