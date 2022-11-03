package com.prep.java8.lambdas.methodref;

public class MethodReferenceExample {

    public static void main(String... args) {

        // simple method call
        printMessage();

        // method call with Thread and lambda
        Thread t = new Thread( () -> printMessage() );
        t.start();

        // there is another way, when a lambda is doing a simple method execution, we can use method reference.
        // 1. You give the name where you have the method
        // 2. You type 2 colon symbols followed by the method name
        // you will have a method reference expression, think of this as an alternate syntax instead.

        Thread t2 = new Thread( MethodReferenceExample::printMessage );
        t2.start();

    }

    public static void printMessage() {
        System.out.println("Hello");
    }

}
