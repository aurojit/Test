package com.puzzle;

import java.util.Scanner;

public class PascalTringle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {

            System.out.println("Enter tringle length: ");
            n = Integer.parseInt(scanner.next());

            for (int row = 0; row < n; row++) {
                for (int space = n; space >= row; space--) {
                    System.out.print(" ");
                }
                for (int col = 0; col <= row; col++) {
                    System.out.print(" " + pascal(row, col));
                }
                System.out.println();
            }
        } while (n != 0);
    }

    private static int pascal(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return pascal(row - 1, col - 1) + pascal(row - 1, col);
        }
    }
}
