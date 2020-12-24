package com.func;

import java.util.function.Predicate;

public class TestPredicte {

    public static void main(String[] args) {
        Predicate<String> predicate = t -> t.startsWith("f") ;

        boolean tes = predicate.test("Aurojit");
        System.out.println(tes);
    }
}
