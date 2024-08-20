package org.example;

public class FactorialNegativeException extends RuntimeException {
    public FactorialNegativeException() {
        super("Факториал отрицательного числа не определен.");
    }
}
