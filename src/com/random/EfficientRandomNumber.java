package com.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EfficientRandomNumber {

    public static final Random random = new Random();

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        List<Integer> unfilledList = new ArrayList<>();
        int randomNumber, count = 0;
        do {
            randomNumber = randomNumberGenerator(returnUniqueSetList(numbers, unfilledList));
            count++;
            System.out.println("RandomNumber = " + randomNumber);
            if (0 != randomNumber && !numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
            unfilledList.clear();
        } while (9 != numbers.size());

        System.out.println("count = " + count);
        System.out.println("NumberSet = " + numbers);

    }

    /**
     * Generate random number
     *
     * @return return random number
     */
    private static int randomNumberGenerator(List<Integer> unfilledList) {
        return unfilledList.get(random.nextInt(unfilledList.size()));
    }

    private static List<Integer> returnUniqueSetList(List<Integer> numbers, List<Integer> unfilledList) {
        for (int i = 1; i <= 9; i++) {
            if (!numbers.contains(i)) {
                unfilledList.add(i);
            }
        }
        return unfilledList;
    }
}
