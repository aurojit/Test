package com.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("w");
        Consumer<List> consumer1 = (dataList) -> {
            System.out.println(dataList);
        };
        Consumer<List> consumer2 = (dataList) -> {
            System.out.println(dataList);
            System.out.println("Hello");
        };

        consumer1.andThen(consumer2).accept(list);
    }
}
