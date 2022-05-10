package com.func;

import com.model.Person;

import java.util.function.Function;

public class Validation {

    public static Function<Person, Person> isValidEmail() {

        return person -> {
            if (person.getValidPerson() && person.getEmail().contains("@")) {
                person.setValidPerson(true);
            } else {

            }
            System.out.println(person);
            return person;
        };
    }

    public static Function<Person, Person> isValidPhone() {
        return person -> {
            if (person.getValidPerson() && person.getPhone().startsWith("+")) {
                person.setValidPerson(true);
            } else {
                person.setValidPerson(false);
            }
            System.out.println(person);
            return person;
        };
    }

    public static Function<Person, Person> isValidName() {
        return person -> {
            if (person.getName().startsWith("A")) {
                person.setValidPerson(true);
            } else {
                person.setValidPerson(false);
            }
            System.out.println(person);
            return person;
        };
    }

}
