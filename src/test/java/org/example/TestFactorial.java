package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestFactorial {
    @Test
    public void testPositive() {
        Assertions.assertEquals(1, Factorial.factorial(1));
        Assertions.assertEquals(2, Factorial.factorial(2));
        Assertions.assertEquals(6, Factorial.factorial(3));
        Assertions.assertEquals(24, Factorial.factorial(4));
        Assertions.assertEquals(120, Factorial.factorial(5));
        Assertions.assertEquals(720, Factorial.factorial(6));
        Assertions.assertEquals(5040, Factorial.factorial(7));
        Assertions.assertEquals(40320, Factorial.factorial(8));
        Assertions.assertEquals(362880, Factorial.factorial(9));
        Assertions.assertEquals(3628800, Factorial.factorial(10));
    }

    @Test
    public void testNegative() {
        // Ожидается вызов исключения.
        Assertions.assertThrows(FactorialNegativeException.class, () -> {
            Factorial.factorial(-1);
        });
    }

    @Test
    public void testFactorialZero() {
        Assertions.assertEquals(1, Factorial.factorial(0)); // 0! = 1
    }
}
