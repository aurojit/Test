package com.puzzle;

public class ArmstrongNumbers {

    public static void main(String[] args) {
        for (int i = 0; i <= 500; i++)
            if (checkNumberIsArmStrong(i))
                System.out.println("Armstrong Numbers are = " + i);
    }

    private static boolean checkNumberIsArmStrong(int number) {
        int sum = 0, remainder;
        int originalNumber = number;
        while (number > 0) {
            remainder = number % 10;
            sum = sum + (remainder * remainder * remainder);
            number = number / 10;
        }
        return (originalNumber == sum);
    }
}
