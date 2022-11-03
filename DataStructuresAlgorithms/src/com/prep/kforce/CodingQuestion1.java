package com.prep.kforce;

public class CodingQuestion1 {

    // you are given a two-digit integer 'n'. Return the sum of its digits.
    // example, for 29 the output should be = 11

    public static void main(String... args){
        CodingQuestion1 question = new CodingQuestion1();
        question.solution(29);
    }

    int solution(int n){
        System.out.println("The parameter is " + n);

        // String representation of n to handle the digits
        // this string should have the length of 2
        String num = Integer.toString(n);

        // adding the numbers
        System.out.println("num[0] is " + Character.getNumericValue( num.charAt(0) ));
        System.out.println("num[1] is " + Character.getNumericValue( num.charAt(1) ));

        int first = Character.getNumericValue( num.charAt(0) );
        int second = Character.getNumericValue( num.charAt(1) );

        System.out.println("returning " + Integer.sum(first, second) );

    return Integer.sum(first, second);
    }

}
