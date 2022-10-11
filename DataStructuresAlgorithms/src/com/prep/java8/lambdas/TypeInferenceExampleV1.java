package com.prep.java8.lambdas;

public class TypeInferenceExampleV1 {

    public static void main (String... args){
        // if you have only one parameter on your lambda, you don't have to specify the type or the params:
        StringLengthLambda myLambda = s -> s.length();
        System.out.println( myLambda.getLength("Hello Lambda") );

        // another way to do this could be:
        printLambda( s -> s.length() );

    }

    public static void printLambda(StringLengthLambda l){
        System.out.println( l.getLength("Hello Lambda") );
    }

    interface StringLengthLambda {
        int getLength(String s);
    }

}
