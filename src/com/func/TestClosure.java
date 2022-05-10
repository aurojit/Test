package com.func;

import java.util.function.Supplier;

public class TestClosure {

    public static void main(String[] args) {
        int a = 10, b = 2;

        Supplier<Integer> add = () -> a + b;
        Supplier<Integer> sub = () -> a - b;
        Supplier<Integer> mul = () -> a * b;

        System.out.println("add : " + add.get());
        System.out.println("sub : " + sub.get());
        System.out.println("mul : " + mul.get());

        int resultF1 = method(20,22);
        int resultF2 = method(20,20);

        System.out.println("TresultF1 : " + resultF1);
        System.out.println("TresultF2 : " + resultF2);
    }

    private static int method (final int f1, final int f2) {

        return f1 + f2;

    }
}
