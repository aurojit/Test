package com.random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class OTPGenerator {

    public static final int OTPDIGIT = 6;

    public static void main(String[] args) {
        Random r = new Random();
        String otp;
        Set<String> otpSet = new HashSet<>();
        long srartTime = System.nanoTime();
        for (int j = 0; j < 50000; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < OTPDIGIT; i++) {
                sb.append(r.nextInt(10));
            }
            otp = sb.toString();
            System.out.println("OTP = " + otp);

            if (otpSet.contains(otp)) {
                System.out.println("Common OTP = " + otp);
            }
            otpSet.add(otp);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - srartTime;
        System.out.println("TotalTime = " + totalTime);
        System.out.println("otpSet.size() = " + otpSet.size());
    }
}
