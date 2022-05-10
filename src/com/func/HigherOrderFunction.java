package com.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HigherOrderFunction {

    public static void main(String[] args) {

        List<String> weeks = new ArrayList<>();
        weeks.add("Sunday");
        weeks.add("Monday");
        weeks.add("Tuesday");
        weeks.add("Wednesday");
        weeks.add("Thursday");
        weeks.add("Friday");
        weeks.add("Saturday");
        Function<List<String>, Function<Integer, String>> process = list -> num -> (num >0 && num<= list.size()) ? list.get(num-1) : "Invalid Input";

        System.out.println("HigherOrderFunction.main:: " + process.apply(weeks).apply(3));

    }
}
