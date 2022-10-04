package com.prep.java8.lambdas;

public interface BasicAddLambda {
    // Lambda as an Interface type or Lambda Function Type
    // we are leveraging the concept of interface for declaring lambda expressions
    // 1. Create a new interface
    // 2. Create a new method into this interface that has EXACTLY the same signature as the lambda you are trying to declare.

    int add(int a, int b);
}
