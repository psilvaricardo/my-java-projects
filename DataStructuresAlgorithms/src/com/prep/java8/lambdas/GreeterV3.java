package com.prep.java8.lambdas;

public class GreeterV3 {

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

        // basic examples
        BasicLambda greeting = () -> System.out.println("Hello Lambdas");
        BasicAddLambda addFunction = (int a, int b) -> a + b;

        // The rule for functional interfaces is,
        // WHEN YOU ARE USING AN INTERFACE TO DECLARE A LAMBDA EXPRESSION, THAT INTERFACE MUST HAVE ONLY ONE METHOD.

        // Here is an example where you have an instance of a specific implementation of your greeting interface.
        GreetingV1 helloLambdasGreeting = new HelloLambdasGreetingV1();

        // but if you already have an interface with the definition of your lambda, you can do something like:
        GreetingV1 lambdagreeting = () -> System.out.println("Hello Lambdas from Lambda");

        // Lambdas VS Interface Implementations
        // line 28 VS line 31

        // line 28 is an instance of a class that implements the Greeting interface.
        // line 31 is behaving like an implementation of the declared type, in a way, we are implementing the function
        // without implementing a class. It is a lambda expression of type Greeting interface.

        helloLambdasGreeting.perform();
        lambdagreeting.perform();

    }

}
