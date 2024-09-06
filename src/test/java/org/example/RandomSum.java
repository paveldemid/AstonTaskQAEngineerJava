package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomSum {

    //После работы метода randomSum в переменной будет храниться сгенирированная сумма платежа.
    private String ramdomSum = "";

    //Метод для генерации случайнного значения суммы.
    public String randomSum() {
        Random random = new Random();
        double number = random.nextInt(10000) + 1;
        number /= 100;

        // Форматирование числа до двух знаков после запятой с запятой как разделителем
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        String formattedNumber = decimalFormat.format(number);
        this.ramdomSum = formattedNumber;
        return this.ramdomSum;
    }

    public String getRamdomSum() {
        return new BigDecimal(ramdomSum.replace(",", ".")).toString();
    }
}
