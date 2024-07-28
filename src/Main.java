import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne;
        int numberTwu;

        TaskLesson7 callMethod = new TaskLesson7();

        //Вызов методов класса TaskLesson7.

        //Задание 1.
        System.out.print("1.");
        callMethod.printThreeWords();
        System.out.print("\n");

        //Задание 2.
        System.out.print("2.");
        callMethod.checkSumSign();
        System.out.print("\n");

        //Задание 3.
        System.out.print("3.");
        callMethod.printColor();
        System.out.print("\n");

        //Задание 4.
        System.out.print("4.");
        callMethod.compareNumbers();
        System.out.print("\n");

        //Задание 5.
        System.out.println("5.Метод sumNumber (метод определяет, находится ли сумма двух чисел в диапазон от 10 до 20))");
        System.out.println("Введите первое число: ");
        numberTwu = scanner.nextInt();
        System.out.println("Введите второе число: ");
        numberOne = scanner.nextInt();
        //Вызов метода и обработка результата работы.
        System.out.println(callMethod.sumNumber(numberOne, numberTwu) ? "true" : "false");
        System.out.print("\n");

        //Задание 6.
        System.out.println("6.Метод negOrPosNamber (метод определяет, " +
                "является ли введеное число положительным или отрицательным))");
        System.out.println("Введите число: ");
        numberOne = scanner.nextInt();
        callMethod.negOrPosNamber(numberOne);
        System.out.print("\n");

        //Задание 7.
        System.out.println("7.Метод trueOrFalseNumber (метод определяет, " +
                "является ли введеное число положительным или отрицательным. Возвращает true или false соотвественно))");
        System.out.println("Введите число: ");
        numberTwu = scanner.nextInt();
        //Вызов метода и обработка результата работы.
        System.out.println(callMethod.trueOrFalseNumber(numberTwu) ? "true" : "false");
        System.out.print("\n");

        //Задание 8.
        System.out.println("8.Метод repeatStr (метод повторяет введеную строку указанное количество раз))");
        System.out.println("Введите строку: ");
        // Очистка буфера
        scanner.nextLine();
        String str = scanner.nextLine();
        System.out.println("Укажите количество повторений: ");
        numberOne = scanner.nextInt();
        callMethod.repeatStr(str, numberOne);
        System.out.print("\n");

        //Задание 9.
        System.out.println("9.Метод leapYear (метод определяет является ли год високосным. " +
                "Возвращает true или false соотвественно)");
        System.out.println("Введите год:");
        numberTwu = scanner.nextInt();
        //Вызов метода и обработка результата работы.
        System.out.println(callMethod.leapYear(numberTwu) ? "true" : "false");
        System.out.print("\n");

        //Задание 10.
        //Для лучшей читаемости кода задание выполнено в отдельном методе класса TaskLesson7.
        System.out.println("10.Метод arrayTask10 (метод заменяет 0 на 1, 1 на 0;)");
        callMethod.arrayTask10();
        System.out.print("\n");

        //Задание 11.
        //Для лучшей читаемости кода задание выполнено в отдельном методе класса TaskLesson7.
        System.out.println("11.Метод arrayTask11 (метод инициализирует массив от 1 до 100)");
        callMethod.arrayTask11();
        System.out.print("\n");

        //Задание 12.
        //Для лучшей читаемости кода задание выполнено в отдельном методе класса TaskLesson7.
        System.out.println("12.Метод arrayTask12 (метод инициализирует массив и " +
                "умножает элементы массива на 2, если они меньше 6)");
        callMethod.arrayTask12();
        System.out.print("\n");

        //Задание 13.
        //Для лучшей читаемости кода задание выполнено в отдельном методе класса TaskLesson7.
        System.out.println("13.Метод arrayTask13 (метод заполняет диагонали квадратного массива)");
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        callMethod.arrayTask13(size);
        System.out.print("\n");

        //Задание 14.
        System.out.println("14.Метод arrayTask14 (метод, принимающий на вход два аргумента: len и initialValue, " +
                "и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.)");

        System.out.println("Введите значение len: ");
        int len = scanner.nextInt();
        System.out.println("Введите значение initialValue: ");
        int initialValue = scanner.nextInt();

        //Вызов метода и обработка результата работы.
        int[] array = callMethod.arrayTask14(len, initialValue);
        System.out.println("Результат работы метода: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}