import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Collections {
    public void list() {
        //В списке 20 слов.
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(
                "Москва", "Токио", "Лондон", "Париж", "Берлин", "Мадрид", "Рим", "Пекин", "Лондон", "Париж",
                "Сидней", "Мадрид", "Токио", "Берлин", "Лондон", "Сидней", "Пекин", "Москва", "Париж", "Берлин"
        ));
        System.out.println("Список слов. Количество: " + arrayList.size() + "\n" + arrayList + "\n");


        //Создание уникального списка слов.
        HashSet<String> setList = new HashSet<>(arrayList);
        System.out.println("Список уникальных слов. Количество: " + setList.size() + "\n" + setList + "\n");

        //Подсчёт количества слов.
        System.out.println("Подсчёт встречаемости каждого слова");
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String word : arrayList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
        System.out.println("\n");
    }
}
