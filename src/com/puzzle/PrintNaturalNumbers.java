package com.puzzle;

public class PrintNaturalNumbers {

    public static void main(String[] args) {
        int n = 3;
        int sum = 0;
        sumOfNumbers(n, sum);
        System.out.println("sum = " + sum);
    }

    private static int sumOfNumbers(int n, int sum) {
        System.out.println("n = " + n);
        System.out.println("sum = " + sum);
        if (n == 1) {
            return sum + 1;
        }
        return sumOfNumbers(n - 1, sum + n);
    }
}
