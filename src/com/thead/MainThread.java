package com.thead;

import java.util.concurrent.Callable;

public class MainThread {
    public static void main(String[] args) {

        int n = 14;

        System.out.println("Main tread name : "+Thread.currentThread().getName());
        Runnable r = () -> {
            for (int i = 0; i < n; i++) {
                System.out.println("i=" + i);
            }
            System.out.println("Child tread name : "+Thread.currentThread().getName());
        };
        System.out.println("Another way...");
        new Thread(r).start();

    }
}
