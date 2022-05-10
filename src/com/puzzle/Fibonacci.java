package com.puzzle;

public class Fibonacci {

    public static void main(String[] args) {

        for (int i = 0; i <= 13; i++)
            System.out.print(" " + printFib(i));
    }

    private static int printFib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return printFib(n - 2) + printFib(n - 1);
        }
    }
}
