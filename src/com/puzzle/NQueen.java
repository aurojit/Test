package com.puzzle;

public class NQueen {

    public static final int CHESS_BOARD_SIZE = 4;

    public static void main(String[] args) {
        int[][] chessboard = new int[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];
        initializedChessBoard(chessboard);
        printChessBoard(chessboard);
        if (!nQueenSolver(chessboard, 0)) {
            System.out.println("Solution not possible");
        } else {
            printChessBoard(chessboard);
        }
    }

    private static boolean nQueenSolver(int[][] chessboard, int i) {

        if (i == CHESS_BOARD_SIZE)
            return true;

        for (int j = 0; j < CHESS_BOARD_SIZE; j++) {

            if (canQueenBePlaced(chessboard, i, j)) {
                chessboard[i][j] = 1;
                if (nQueenSolver(chessboard, i + 1))
                    return true;

                chessboard[i][j] = 0;
            }
        }

        return false;
    }

    /*private static boolean nQueenSolver(int[][] chessboard, int i, int j) {
        int placeCoordinateX = -1;
        int placeCoordinateY = -1;
        for (; i < CHESS_BOARD_SIZE; i++) {
            boolean canPlacedRow = false;
            for (; j < CHESS_BOARD_SIZE; j++) {
                boolean canPlaced = canQueenBePlaced(chessboard, i, j);
                if (canPlaced) {
                    chessboard[i][j] = 1;
                    placeCoordinateX = i;
                    placeCoordinateY = j;
                    canPlacedRow = true;
                }
            }

            printChessBoard(chessboard);
            if (!canPlacedRow) {
                System.out.println("placeCoordinateX: " + placeCoordinateX);
                System.out.println("placeCoordinateY: " + placeCoordinateY);
                chessboard[placeCoordinateX][placeCoordinateY] = 0;
                int counter = 0;
                if ((placeCoordinateY + 1) > 3) {
                    counter = 0;
                } else {
                    counter = placeCoordinateY + 1;
                }
                System.out.println("i: " + i + ", j: " + j + ", counter: " + counter);
                return nQueenSolver(chessboard, i - 1, counter);
            }
            j = 0;
        }
        return true;
    }*/

    /**
     * Logic of if the queen can be placed or not on a given co-ordinate.
     *
     * @param chessboard chessboard
     * @param row        row
     * @param col        col
     * @return return
     */
    private static boolean canQueenBePlaced(int[][] chessboard, int row, int col) {

        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            if (chessboard[row][i] != 0) {
                return false;
            }
        }
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            if (chessboard[i][col] != 0) {
                return false;
            }
        }
        for (int i = 1; i <= CHESS_BOARD_SIZE; i++) {
            int diagRow = row - i;
            int diagCol = col + i;
            if ((diagRow >= 0 && diagRow < CHESS_BOARD_SIZE) && (diagCol >= 0 && diagCol < CHESS_BOARD_SIZE) && chessboard[diagRow][diagCol] != 0) {
                return false;
            }
            diagRow = row + i;
            diagCol = col - i;
            if ((diagRow >= 0 && diagRow < CHESS_BOARD_SIZE) && (diagCol >= 0 && diagCol < CHESS_BOARD_SIZE) && chessboard[diagRow][diagCol] != 0) {
                return false;
            }
        }
        for (int i = 1; i <= CHESS_BOARD_SIZE; i++) {
            int diagRow = row + i;
            int diagCol = col + i;
            if ((diagRow >= 0 && diagRow < CHESS_BOARD_SIZE) && (diagCol >= 0 && diagCol < CHESS_BOARD_SIZE) && chessboard[diagRow][diagCol] != 0) {
                return false;
            }
            diagRow = row - i;
            diagCol = col - i;
            if ((diagRow >= 0 && diagRow < CHESS_BOARD_SIZE) && (diagCol >= 0 && diagCol < CHESS_BOARD_SIZE) && chessboard[diagRow][diagCol] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print Chess Board.
     *
     * @param chessboard chessboard
     */
    private static void printChessBoard(int[][] chessboard) {
        System.out.println("******************");
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                System.out.print(" " + chessboard[i][j]);
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
