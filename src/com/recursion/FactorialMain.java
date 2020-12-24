package com.recursion;

public class FactorialMain {

    public static void main(String[] args) {

        System.out.println("FactorialMain.main:" + factorial(5, 1));

    }

    public static int factorial(int number, int result) {

        if (number == 0) return result;
        else return factorial(number - 1, number * result);

    }
}
