package com.puzzle;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {5, 15, 7, 1, 6, 10, 13, 9, 12, 3, 71, 81, 72, 82, 15, 7, 1, 6, 10, 13, 9, 12, 3, 71, 81, 72, 82, 73, 83, 69, 99};
        int numbersLength = numbers.length, i = 0;
        int searchNumber = 99;
        long startTime = System.nanoTime();
        for (i = 0; i < numbersLength; i++) {
            if (numbers[i] == searchNumber) {
                System.out.println("Found:" + i);
                break;
            }
        }
        if (i == numbersLength)
            System.out.println("Not Found");
        long endTime = System.nanoTime();
        System.out.println("endTime - startTime = " + (endTime - startTime));
    }
}
