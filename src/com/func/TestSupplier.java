package com.func;

import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> {
            return "Hello";
        };

        System.out.println(supplier.get());
    }
}
