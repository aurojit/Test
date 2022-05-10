package com.puzzle;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        int year = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter year: ");
            year = Integer.parseInt(scanner.next());
            if ((year % 100 == 0 && year % 400 == 0) || (0 != year % 100 && year % 4 == 0))
                System.out.println("Leap-Year");
            else
                System.out.println("Not Leap-Year");
            System.out.println(".........Enter any negative number to exit the loop or positive number to continue............");
        } while (Integer.parseInt(scanner.next()) <= 0 ? false : true);
    }
}
