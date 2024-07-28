public class TaskLesson7 {

    //Задание 1.
    public void printThreeWords() {
        System.out.println("Результат работы метода printThreeWords: ");
        System.out.println("Orange\nBanana\nApple");
    }

    //Задание 2.
    public void checkSumSign() {
        int a = 3;
        int b = 4;
        int sum = a + b;

        System.out.println("Результат работы метода checkSumSign: ");

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //Задание 3.
    public void printColor() {
        int value = 101;

        System.out.println("Результат работы метода printColor: ");

        if (value <= 0) {
            System.out.println("Крвсный");
        } else if (0 < value && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //Задание 4.
    public void compareNumbers() {
        int a = 3466;
        int b = 33;

        System.out.println("Результат работы метода compareNumbers: ");

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a<b");
        }
    }

    //Задание 5.
    public boolean sumNumber(int numberOne, int numberTwu) {
        int sum = numberOne + numberTwu;

        System.out.println("Результат работы метода sumNumber: ");

        if (10 < sum && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //Задание 6.
    public void negOrPosNamber(int number) {

        System.out.println("Результат работы метода negOrPosNamber: ");

        if (number < 0) {
            System.out.println("Переданое число является отрицательным");
        } else {
            System.out.println("Переданое число  является положительным");
        }
    }

    //Задание 7.
    public boolean trueOrFalseNumber(int number) {
        System.out.println("Результат работы метода trueOrFalseNumber: ");

        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }

    //Задание 8.
    public void repeatStr(String str, int repeat) {

        System.out.println("Результат работы метода repeatStr: ");

        for (int i = 1; i <= repeat; i++) {
            System.out.println(i + ":" + str);
        }
    }

    //Задание 9.
    public boolean leapYear(int year) {

        System.out.println("Результат работы метода learYear: ");

        if ((year % 400 == 0 || year % 100 != 0) && (year % 4 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    //Задание 10.
    public void arrayTask10() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.print("Заданный массив:\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        // Замена 0 на 1, 1 на 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                if (array[i] == 1) {
                    array[i] = 0;
                }
            }
        }

        System.out.println(" ");
        System.out.println("Результат работы: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    //Задание 11.
    public void arrayTask11() {
        int[] array = new int[100];

        System.out.println("Результат работы: ");
        //Инициализация массива и вывод элементов массива в консоль.
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    //Задание 12.
    public void arrayTask12() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.print("Заданный массив:\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");
        System.out.println("Результат работы: ");
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (element < 6) {
                array[i] = element * 2;
            }
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }

    //Задание 13.
    public void arrayTask13(int size) {
        int[][] array = new int[size][size];

        // Заполнение диагональных элементов единицами
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - 1 - i] = 1;
        }

        // Вывод массива на экран
        System.out.println("Квадратный двумерный массив с заполненными диагоналями:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " "); // Вывод элементов массива
            }
            System.out.println(); // Переход на новую строку после каждой строки массива
        }
    }

    //Задание 14.
    public int[] arrayTask14(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
