package com.prep.java8.lambdas.exceptions;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    /** For this example we will have a lambda that takes an array of integers
     * and a key which is an integer, and do a math operation for each element based on the key */
    public static void main(String... args) {
        int key = 0;
        int[] someNumbers = { 1, 2, 3, 4 };

        // process(someNumbers, key, (v, k) -> System.out.println( v / k) );

        process( someNumbers,
                key,
                wrapperLambdaExHandler((v, k) -> System.out.println( v / k))
        );
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {

        for (int i : someNumbers){
            consumer.accept(i, key);
        }
    }

    /**
     * There are a few different ways to handle this and keep our lambdas simple, instead of
     * having a try-catch as part of the lambda, for this example, we can externalize the
     * try-catch into a separate function and then, wrap the first lambda into another lambda
     * that has the try-catch, a wrapper lambda that has to do with the same Type
     */

    private static BiConsumer<Integer, Integer> wrapperLambdaExHandler( BiConsumer<Integer, Integer> consumer ) {
        // this would be an authentic wrapper...
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            }
            catch (Exception e) {
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }

}
