package com.func;

import com.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunction {

    public static void main(String[] args) {
        Function<Integer, String> basic = (key) -> {
            return key%2 == 0 ? "Even Number" : "Odd Number";
        };

        String apply = basic.apply(14);

        System.out.println(apply);

        Map<String, Integer> mapData = new HashMap<String, Integer>();
        mapData.put("ke1", 1);
        mapData.put("ke2", 2);
        mapData.put("ke3", 3);
        mapData.put("ke4", 4);
        mapData.put("ke5", 5);
        System.out.println(mapData);

        mapData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });

        Person person = new Person("Aurojit", "abc@g.com", "+9100023");

        Person person2 = Validation.isValidName().andThen(Validation.isValidEmail()).andThen(Validation.isValidPhone()).apply(person);
        System.out.println("Valid : " + person2.getValidPerson());
    }
}
