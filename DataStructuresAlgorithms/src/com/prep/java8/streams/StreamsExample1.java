package com.prep.java8.streams;

import com.prep.java8.lambdas.exercise.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {

    public static void main(String... args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // as of Java8, every collection comes with the stream method
        // and they can leverage parallel processing.
        people
        .stream()
        .filter( p -> p.getLastName().startsWith("C"))
        .forEach(System.out::println);

        long count = people
                .parallelStream()
                .filter( p -> p.getLastName().startsWith("D"))
                .count();
        System.out.println(count);

    }

}
