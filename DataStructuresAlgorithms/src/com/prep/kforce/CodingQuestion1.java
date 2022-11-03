package com.prep.kforce;

public class CodingQuestion1 {

    // given a positive integer number N, your task is to calculate the difference between
    // the product of its digits and the sum of its digits
    // example, for n = 123456 the output should be
    // product = 1*2*3*4*5*6 = 720
    // sum = 1+2+3+4+5+6 = 21
    // solution = 699

    public static void main(String... args){
        CodingQuestion1 question = new CodingQuestion1();
        question.solution(123456);
    }

    int solution(int n){
        System.out.println("The parameter is " + n);

        int sum = 0;
        int product = 1;

        // String representation of n to handle the digits
        String strNum = Integer.toString(n);
        for (char c : strNum.toCharArray()){
            System.out.println("strNum.toCharArray() char is " + c);
            sum += Character.getNumericValue( c );
            product *= Character.getNumericValue( c );
        }

        // adding the numbers
        System.out.println("sum is " + sum );
        System.out.println("product is " + product );
        int answer = product - sum;

        System.out.println("returning " + answer );

        return answer;
    }

}
