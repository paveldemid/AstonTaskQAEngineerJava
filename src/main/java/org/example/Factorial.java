package org.example;

public class Factorial {
    public static long factorial(int number) {
        long factorial = 1;

        if (number < 0) {
            throw new FactorialNegativeException();

        } else {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

        }
        return factorial;
    }
}