package com.prep.java8.lambdas.collections;

import com.prep.java8.lambdas.exercise.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String... args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // the popular way to iterate is the for loop...
        System.out.println("Using classic for loop");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        // using for-in loop
        System.out.println("Using for-in loop");
        for (Person p : people) {
            System.out.println(p);
        }

        // the previous two are using external iterators,..
        // for Java8, we have a new method as part of Collections called for-each loop
        // this new method as an instance of Consumer as parameter, so you can pass a lambda expression to it
        // meaning, for each element of the collection, we will use the lambda expression passed as parameter.
        // this new syntax makes a lot easier to have multi-threading and parallelism

        System.out.println("Using Collections' for-each loop");
        // people.forEach( p -> System.out.println(p) );
        people.forEach( System.out::println );

    }

}
