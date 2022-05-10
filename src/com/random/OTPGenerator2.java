package com.random;

import java.util.HashSet;
import java.util.Set;

public class OTPGenerator2 {

    public static final int OTPDIGIT = 6;

    public static void main(String[] args) {

        Set<String> otpSet = new HashSet<>();
        long srartTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            long nanotime = System.nanoTime();
            String otp = String.valueOf(nanotime).substring(String.valueOf(nanotime).length() - OTPDIGIT);
            System.out.println("otp = " + otp);
            if (otpSet.contains(otp)) {
                System.out.println("Common OTP = " + otp);
            }
            otpSet.add(otp);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - srartTime;
        System.out.println("totalTime = " + totalTime);
        System.out.println("otpSet.size() = " + otpSet.size());
    }
}
