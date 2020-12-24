package com.random;

import java.util.Random;

public class RandomMain {

    public static void main(String[] args) {

        Random r = new Random();

        int number = 0;
        for (int i = 0; i < 100; i++) {
            int rand = r.nextInt(999999);
            if(rand <= 99999) {
                System.out.println("Discard=" + i + "::::" + rand);
                continue;
            }
            System.out.println("Int:: i=" + i + "::::" + rand);
            number = rand;
            break;
        }
        System.out.println("number = " + number);
    }
}
