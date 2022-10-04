package com.prep.java8.lambdas;

public class RunnableExampleUsingLambda {

    public static void main (String... args) {
    /*    Thread myThread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Printed inside runnable");
                    }
                }
        );
        myThread.run();
    */

        // The Thread class has been implemented way before Java8, this is the magic of having an interface mechanism
        // for declaring lambdas, you get this huge backward compatibility and all the old APIs that we come to know
        // and love with Java are still accessible but now with lambdas. We are using Functional Interfaces.
        Thread myLambdaThread = new Thread( () -> System.out.println("Printed inside runnable lambda") );
        myLambdaThread.run();
    }

}
