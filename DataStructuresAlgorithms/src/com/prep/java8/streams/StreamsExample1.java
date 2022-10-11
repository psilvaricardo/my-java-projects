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

    /**
     * Streams are using functional programming heavily and are supported starting in Java 8
     *
     * Stream Source: they can be created from Collections, Lists, Sets, ints, longs, doubles, arrays, lines of a file.
     *
     * They make heavy use of lambda expressions
     * ParallelStreams make it very easy can leverage parallel processing, multi-thread operations
     * A stream pipeline consists of a source, followed by zero or more intermediate operations
     * and a terminal operation.
     *
     * Intermediate operations: filter, map or sort return a stream, so we can chain multiple intermediate operations.
     * Zero or more intermediate operations are allowed. Order matter for large datasets: filter first, then sort or map.
     * For very large datasets, use ParallelStream to enable multiple threads. Intermediate operations include:
     *
     *      anyMatch()      flatpam()
     *      distinct()      map()
     *      filter()        skip()
     *      findFirst()     sorted()
     *
     * Terminal operations: forEach, Collect, reduce are either void or return a non-stream result.
     *
     *      forEach(): applies the same operations to each element, for example print.
     *      collect(): will save all the elements into a collection
     *
     * other operations reduce the stream to a single summary element:
     *
     *      count()         min()
     *      max()           reduce()
     *      summaryStatistics()
     *
     **/

}
