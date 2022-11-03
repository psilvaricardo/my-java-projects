package com.prep.java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample2 {

    public static void main(String... args) throws IOException {

        // 1. Integer Stream
        System.out.println("Integer Stream");
        IntStream
                .range(1, 10) // from 1 to 9 as 10 is non-inclusive
                .forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        System.out.println("Integer Stream with skip");
        IntStream
                .range(1, 10) // from 1 to 9 as 10 is non-inclusive
                .skip(5)
                .forEach(System.out::print);
        System.out.println();

        // 3. Integer Stream with skip
        System.out.println("Integer Stream with sum");
        System.out.println(
            IntStream
                    .range(1, 10) // from 1 to 9 as 10 is non-inclusive
                    .sum()
                );
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        System.out.println("Stream.of, sorted and findFirst");
        Stream.of("Ava", "Ariaty", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                        .ifPresent(System.out::println);
        System.out.println();


        // 5. Stream from Array, sort, filter and print
        System.out.println("Stream from Array, sort, filter and print");
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)	// same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();


        // 6. Average of squares of an int array
        System.out.println("Average of squares of an int array");
        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        // 7. Stream from List, filter and print
        System.out.println("Stream from List, filter and print");
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        // 8. Stream rows from text file, sort, filter, and print
        System.out.println("Stream rows from text file, sort, filter, and print");
        Stream<String> bands = Files.lines(Paths.get("src/com/prep/java8/streams/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close(); // to prevent memory leaks
        System.out.println();

        // 9. Stream rows from text file and save to List
        System.out.println("Stream rows from text file and save to List");
        List<String> bands2 = Files.lines(Paths.get("src/com/prep/java8/streams/bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));
        System.out.println();

        // 10. Stream rows from CSV file and count
        System.out.println("Stream rows from CSV file and count");
        Stream<String> rows1 = Files.lines(Paths.get("src/com/prep/java8/streams/data.txt"));
        int rowCount = (int)rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        System.out.println();

        // 11. Stream rows from CSV file, parse data from rows
        System.out.println("Stream rows from CSV file, parse data from rows");
        Stream<String> rows2 = Files.lines(Paths.get("src/com/prep/java8/streams/data.txt"));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
        rows2.close();
        System.out.println();


        // 12. Stream rows from CSV file, store fields in HashMap
        System.out.println("Stream rows from CSV file, store fields in HashMap");
        Stream<String> rows3 = Files.lines(Paths.get("src/com/prep/java8/streams/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }
        System.out.println();

        // 13. Reduction - sum
        System.out.println("Reduction - sum");
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
        System.out.println();

        // 14. Reduction - summary statistics
        System.out.println("Reduction - summary statistics");
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);
        System.out.println();

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
