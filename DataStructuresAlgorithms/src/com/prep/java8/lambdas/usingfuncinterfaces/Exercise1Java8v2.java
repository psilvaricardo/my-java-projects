package com.prep.java8.lambdas.usingfuncinterfaces;

import com.prep.java8.lambdas.exercise.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise1Java8v2 {

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
        performConditionally( people, p -> true, p -> System.out.println(p) );

        // 3. Create a method that prints all people that have last name beginning with C
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
    }

    // Using an out-to-the-box interface Predicate<T> and  that comes with Java8 and later
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for(Person p : people){
            if ( predicate.test(p) ){
                consumer.accept(p);
            }
        }
        System.out.println();
    }

}
