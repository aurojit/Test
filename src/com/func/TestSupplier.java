package com.func;

import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hello";

        System.out.println(supplier.get());
    }
}
