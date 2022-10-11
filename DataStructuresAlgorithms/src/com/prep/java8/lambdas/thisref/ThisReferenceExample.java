package com.prep.java8.lambdas.thisref;

import com.prep.java8.lambdas.closures.Process;

public class ThisReferenceExample {

    /**
     * In this example we will explore the difference between lambda expressions
     * VS anonymous inner class, the 'this' reference for any object refers to
     * the instance for that object itself.
     *
     * It works just like you would expect it to from an anonymous inner class,
     * but it doesn't quite work that way for a lambda expression.
     *
     * This is, among some other things, a true indication that a lambda expression
     * is not really a syntactical sugar around anonymous inner classes, but it's
     * that it is its own thing...
     **/

    public static void main(String... args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println( "Value of i is " + i );
                System.out.println( this ); // called from an instance of an object
                /* WHEN USING AN ANONYMOUS INNER CLASS, WHEN WE USE 'this' REFERENCE,
                * YOU BASICALLY OVERWRITE THIS REFERENCE, BUT IN THE CASE OF A LAMBDA
                * THAT DOES NOT HAPPEN, 'this' STILL REFERS TO THE INSTANCE THAT IT
                * POINTS OUTSIDE OF THE LAMBDA, NO OVERWRITE */
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });

        // the same but now using a lambda expression
        thisReferenceExample.doProcess(20, i -> {
            System.out.println( "Value of i is " + i );
            // System.out.println( this ); // this will not work
        } );


        // calling the same lambda from an instance method
        thisReferenceExample.execute();


    }

    // copied from the previous example but let's make it non-static
    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        // this === ???
        // 'this' points to the instance of the object on which the execute method is being called.

        doProcess(30, i -> {
            System.out.println( "Value of i is " + i );
            System.out.println( this );
        } );
    }

    @Override
    public String toString() {
        return "This is the ThisReferenceExample class instance";
    }

}
