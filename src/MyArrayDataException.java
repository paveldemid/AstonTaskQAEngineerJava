class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int lines, int column, String[][] array) {
        super("Ошибка преобразования в тип int. Строка " + lines + ". Столбец " + column + ". Элемент: " + array[lines][column]);
    }
}