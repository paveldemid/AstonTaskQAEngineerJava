import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberGuide {
    HashMap<String, List<String>> userList = new HashMap<>();

    public void add(String userName, String phoneNumber) {
        userList.putIfAbsent(userName, new ArrayList<>());
        userList.get(userName).add(phoneNumber);
    }

    public void get(String userName) {
        if (userList.containsKey(userName)) {
            System.out.println("Результат поиска для фамилии: " + userName + ", Количество записей: " + userList.get(userName).size());
            System.out.println(userList.get(userName));
        } else {
            System.out.println("Запись не найдена для фамилии: " + userName);
        }
    }
}
