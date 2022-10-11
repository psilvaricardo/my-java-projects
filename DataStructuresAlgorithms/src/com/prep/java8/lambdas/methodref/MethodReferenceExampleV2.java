package com.prep.java8.lambdas.methodref;

import com.prep.java8.lambdas.exercise.Condition;
import com.prep.java8.lambdas.exercise.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExampleV2 {

    public static void main(String... args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Call a method that prints all elements in the list using a method reference
        printConditionally( people, p -> true, System.out::println ); // p -> method(p)

    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for(Person p : people){
            if ( predicate.test(p) ){
                consumer.accept(p);
            }
        }
        System.out.println();
    }

}