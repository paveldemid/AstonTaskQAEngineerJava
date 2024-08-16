public class Array {
    public static void arrayString(String[][] array) {
        //Проверка размера массива.
        if (array.length != 4 || (array.length > 0 && array[0].length != 4)) {
            throw new MyArraySizeException();
        } else {
            System.out.println("Размер массива корректный.");
            int summ = 0;

            //Проход по массиву.
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    try {
                        summ = summ + Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, array);
                    }
                }
            }
            System.out.println("Сумма элементов массива равна: " + summ);
        }
    }
}



