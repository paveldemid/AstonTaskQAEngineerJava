class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Размер массива должен быть 4x4");
    }
}