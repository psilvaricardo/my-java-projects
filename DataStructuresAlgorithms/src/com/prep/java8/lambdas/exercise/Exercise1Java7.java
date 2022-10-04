package com.prep.java8.lambdas.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise1Java7 {

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


        // Solution in Java 7 style
        // 1. Sort list by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getLastName().compareTo(t1.getLastName());
            }
        });

        // 2. Create a method that prints all elements in the list
        printAll(people);

        // 3. Create a method that prints all people that have last name beginning with C
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("C");
            }
        });

        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("C");
            }
        });
    }

    private static void printAll( List<Person> people) {
        for(Person p : people){
            System.out.println(p);
        }
        System.out.println();
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
