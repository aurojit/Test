package com.hacker.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DistinctChar {
    private final String name;
    private final int charCount;

    public DistinctChar(String name, int charCount) {
        this.name = name;
        this.charCount = charCount;
    }

    public String getName() {
        return name;
    }

    public int getCharCount() {
        return charCount;
    }

    @Override
    public String toString() {
        return "DistinctChar{" +
                "name='" + name + '\'' +
                ", charCount=" + charCount +
                '}';
    }
}

public class FindDistinctChar {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("aurojit");
        names.add("aureeei");
        names.add("bureeei");
        names.add("auqaaatt");

        names.stream()
                .filter(name -> name.startsWith("a"))
                .map(name -> {
                    Set<String> characterSet = new HashSet<>();
                    for (int i = 0; i < name.length(); i++) {
                        characterSet.add(String.valueOf(name.charAt(i)));
                    }
                    return new DistinctChar(name, characterSet.size());
                })
                .filter(distinctChar -> distinctChar.getCharCount() > 6)
                .forEach(System.out::println);
    }
}
