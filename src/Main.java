
public class Main {
    public static void main(String[] args) {
        // Пример с некорректным массивом
        String[][] invalidArray = {
                {"1", "y", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример с корректным массивом
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Тестирование некорректного массива
        try {
            Lesson12.arrayString(invalidArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // Тестирование корректного массива
        try {
            Lesson12.arrayString(validArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
}