package com.prep.java8.lambdas.closures;

public class ClosuresExample {

    public static void main(String... args) {
        int a = 10;
        int b = 20; // the compiler expects this to be effectively final

        doProcess(a, new Process() {
            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });

        // the concept of closure is, the JRE freezes the value of b along with the lambda expression,
        // wherever that lambda expression goes, it will take the frozen value of b at that time.
        doProcess(a, i -> System.out.println(i + b));

        // if the value of b changes later, it does not matter, that doProcess call will have a 'final'
        // value of b wherever the lambda expressions goes.

    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }

}
