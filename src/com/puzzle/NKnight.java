package com.puzzle;

public class NKnight {

    public static final int CHESS_BOARD_SIZE = 5;

    /**
     * N-Knight problem starts here.
     *
     * @param args Empty command line argument.
     */
    public static void main(String[] args) {
        int i = 0, j = 0;
        int[][] chessboard = new int[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];
        System.out.println("Welcome to N-Knight problem where N is " + CHESS_BOARD_SIZE);
        initializedChessBoard(chessboard);
        printChessBoard(chessboard);
        chessboard[i][j] = 1; //Initial Place of Knight
        if (!nKnightSolver(chessboard, 1, i, j)) {
            chessboard[i][j] = 0;
            System.out.println("No Solution found.");
        }
        printChessBoard(chessboard);
    }

    /**
     * @param chessboard chessboard
     * @param count      count will calculate total count.
     * @param i          i is the knight's current X co-ordinate.
     * @param j          j is the knight's current Y co-ordinate.
     * @return boolean
     */
    private static boolean nKnightSolver(int[][] chessboard, int count, int i, int j) {

        if (count == (CHESS_BOARD_SIZE * CHESS_BOARD_SIZE))
            return true;

        int[] rows = {-1, -2, -2, -1, +1, +2, +2, +1};
        int[] cols = {+2, +1, -1, -2, -2, -1, +1, +2};

        for (int k = 0; k < 8; k++) {
            if (canKnightBePlaced(chessboard, i + rows[k], j + cols[k])) {
                chessboard[i + rows[k]][j + cols[k]] = count + 1;
                if (nKnightSolver(chessboard, count + 1, i + rows[k], j + cols[k]))
                    return true;

                chessboard[i + rows[k]][j + cols[k]] = 0; //BACK-TRACKING
            }
        }
        return false;
    }

    /**
     * Logic of if the knight can be placed or not on a given co-ordinate.
     *
     * @param chessboard chessboard
     * @param row        row
     * @param col        col
     * @return return
     */
    private static boolean canKnightBePlaced(int[][] chessboard, int row, int col) {
        return (row >= 0 && row < CHESS_BOARD_SIZE) && (col >= 0 && col < CHESS_BOARD_SIZE) && chessboard[row][col] == 0;
    }

    /**
     * Print Chess Board.
     *
     * @param chessboard chessboard
     */
    private static void printChessBoard(int[][] chessboard) {
        System.out.println("***********************");
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                System.out.printf("%4d", chessboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialized the Chess Board.
     *
     * @param chessboard chessboard
     */
    private static void initializedChessBoard(int[][] chessboard) {
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                chessboard[i][j] = 0;
            }
        }
    }
}
