package com.prep.java8.lambdas;

public class GreeterV2 {

    public void greet(GreetingV1 greeting ){
        // here we are adding a customization
        greeting.perform();
    }

    public static void main (String... args){
        GreeterV2 greeter = new GreeterV2();
        HelloLambdasGreetingV1 helloLambdasGreetingV1 = new HelloLambdasGreetingV1();
        // here is where I'm passing a custom "behavior" to the greet method by creating an implementation of the GreetingV1 interface.
        // we are passing a "thing that has a behavior", we are just passing an "action or function" and we just execute the action inside.
        // Lambda lets you create this functions that exist in isolation and can be threaded as "values".

        greeter.greet(helloLambdasGreetingV1);

        // so far, you can assign 'values' to variables, different types or objects, like:
        // String name = "foo";
        // double pi = 3.14;

        // can we assign a block of code to a variable??
        /*
        * aBlockOfCode  = {
        * ...
        * ...
        * }
        *
        * In Java8 and later, if a function exists in isolation, this is the minimum you can write for a lambda expression:
        *
        * aBlockOfCode = () -> { System.out.println("Hello Lambdas"); };
        *
        * if you know how to write a method in Java, you will know how to write a lambda expression in Java.
        * 1. Take a method.
        * 2. Remove the modifiers, the name and the return type.
        * 3. What's left, is a lambda expression that can be assigned to a variable.
        * 4. If the body of your lambda expression is only one line, you can remove the curly braces.
        *
        * FROM:
        *
        * aBlockOfCode  = public void greet(){
        *   System.out.println("Hello Lambdas");
        * }
        *
        * TO:
        *
        * aBlockOfCode = () -> System.out.println("Hello Lambdas");
        *
        **/

    }

}
