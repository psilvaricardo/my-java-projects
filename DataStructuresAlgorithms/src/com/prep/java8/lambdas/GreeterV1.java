package com.prep.java8.lambdas;

public class GreeterV1 {

    public void greet(){
        System.out.println("Hello Lambdas");
    }

    public static void main (String... args){
        GreeterV1 greeter = new GreeterV1();
        greeter.greet();
    }
}
