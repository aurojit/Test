package com.puzzle;

public class PalindromeNumber {
    public static void main(String[] args) {

        if (isPalindromeNumber(3223))
            System.out.println("Palindrome Numbers are = " + 3223);
    }

    private static boolean isPalindromeNumber(int number) {
        int reversedNumber = 0, remainder;
        int originalNumber = number;
        while (number > 0) {
            remainder = number % 10;
            reversedNumber = (reversedNumber * 10) + remainder;
            number = number / 10;
        }
        return (originalNumber == reversedNumber);
    }
}
