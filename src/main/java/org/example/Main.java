package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число для вычисления факториала: ");
            int number = scanner.nextInt();
            System.out.println("Факториал числа " + number + " равен " + Factorial.factorial(number));
            scanner.close();
        } catch (FactorialNegativeException e) {
            System.out.println(e.getMessage());
        }
    }
}