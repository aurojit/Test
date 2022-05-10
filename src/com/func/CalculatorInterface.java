package com.func;

@FunctionalInterface
public interface CalculatorInterface {
    int calculate(int a, int b);

    static int stat() {
        return 1 + 3;
    }

    default String test(String a, String b) {
        return a + b;
    }
}
