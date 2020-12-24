package com.thead;

public class TestThread implements Runnable {

    int n = 0;
    public TestThread(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("i=" + i);
        }
        System.out.println("Child tread name : "+Thread.currentThread().getName());
    }
}
