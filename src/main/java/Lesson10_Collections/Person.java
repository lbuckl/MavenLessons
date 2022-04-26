package Lesson10_Collections;

import java.util.HashSet;
import java.util.Set;

public class Person {
    String name;
    Set<String> numbers = new HashSet<>(); // Используем, потому что записываются только уникальные значения

    Person (String name){
        this.name = name;
    }

    public String getNumbers() {
        return numbers.toString();
    }

    public void setNumber(String number) {
        numbers.add(number);
    }
}
