package com.random;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RandomNumber {

    public static void main(String[] args) {

        Random r = new Random();

        List<Integer> numbers = new ArrayList<>();
        int randomNumber, count = 0;
        do {
            randomNumber = r.nextInt(10);
            count++;
            System.out.println("randomNumber = " + randomNumber);
            if (0 != randomNumber && !numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        } while (9 != numbers.size());

        System.out.println("count = " + count);
        System.out.println("numberSet = " + numbers);
    }
}
