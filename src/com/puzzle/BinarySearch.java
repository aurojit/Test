package com.puzzle;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {5, 15, 7, 1, 6, 10, 13, 9, 12, 3, 71, 81, 72, 82, 15, 7, 1, 6, 10, 13, 9, 12, 3, 71, 81, 72, 82, 73, 83, 69, 99};
        int numbersLength = numbers.length;
        int searchNumber = 82;
        printArray(numbers, numbersLength);
        sortTheArray(numbers, numbersLength);
        printArray(numbers, numbersLength);
        long startTime = System.nanoTime();
        binarySearch(numbers, 0, numbersLength - 1, searchNumber);
        long endTime = System.nanoTime();
        System.out.println("endTime - startTime = " + (endTime - startTime));
    }

    private static void binarySearch(int[] numbers, int start, int end, int searchNumber) {
        int middle = (start + end) / 2;

        System.out.println("Middle " + middle);
        if (end < start) {
            System.out.println(searchNumber + " Number Not Found");
            return;
        }
        if (numbers[middle] == searchNumber) {
            System.out.println("Number found in index number = " + middle);
        } else if (numbers[middle] > searchNumber)
            binarySearch(numbers, start, middle - 1, searchNumber);
        else
            binarySearch(numbers, middle + 1, end, searchNumber);
    }

    private static void sortTheArray(int[] numbers, int numbersLength) {
        int temp;
        for (int i = 0; i < numbersLength; i++) {
            for (int j = 1; j < (numbersLength - i); j++) {
                if (numbers[j - 1] > numbers[j]) {
                    temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    private static void printArray(int[] numbers, int numbersLength) {
        for (int j = 0; j < numbersLength; j++) {
            System.out.printf("%4d", numbers[j]);
        }
        System.out.println();
    }
}
