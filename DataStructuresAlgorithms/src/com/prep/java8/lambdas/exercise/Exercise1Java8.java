package com.prep.java8.lambdas.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise1Java8 {

    public static void main(String... args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // 1. Sort list by last name
        // 2. Create a method that prints all elements in the list
        // 3. Create a method that prints all people that have last name beginning with C

        // Solution in Java 8 style
        // 1. Sort list by last name
        Collections.sort( people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) );

        // 2. Create a method that prints all elements in the list
        printConditionally( people, p -> true );

        // 3. Create a method that prints all people that have last name beginning with C
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        printConditionally(people, p -> p.getFirstName().startsWith("C"));
    }

    private static void printConditionally( List<Person> people, Condition condition) {
        for(Person p : people){
            if ( condition.test(p) ){
                System.out.println(p);
            }
        }
        System.out.println();
    }

}
