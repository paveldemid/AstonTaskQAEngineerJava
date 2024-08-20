package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TestFactorial {

    @Test
    public void testPositive() {
        assertEquals(Factorial.factorial(1), 1);
        assertEquals(Factorial.factorial(2), 2);
        assertEquals(Factorial.factorial(3), 6);
        assertEquals(Factorial.factorial(4), 24);
        assertEquals(Factorial.factorial(5), 120);
        assertEquals(Factorial.factorial(6), 720);
        assertEquals(Factorial.factorial(7), 5040);
        assertEquals(Factorial.factorial(8), 40320);
        assertEquals(Factorial.factorial(9), 362880);
        assertEquals(Factorial.factorial(10), 3628800);
    }

    @Test
    public void testNegative() {
        // Ожидается вызов исключения.
        assertThrows(FactorialNegativeException.class, () -> {
            Factorial.factorial(-1);
        });
    }

    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.factorial(0), 1); // 0! = 1
    }
}
